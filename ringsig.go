package main

/*
#cgo CFLAGS: -I.
#cgo LDFLAGS: -L./ -lsmth
#include <stdio.h>
#include <openssl/bn.h>
#include <openssl/sm3.h>
*/
import "C"
import (
	"bytes"
	"crypto"
	_ "crypto"
	"encoding/hex"
	"fmt"
	"strconv"
	"unsafe"
)
const(
	// 定义一个常变量
	RSA_NUM=2048
)

type Ring_Keys struct {
	// 定义还签名密钥
	n int
	z int
	pub_e []*C.BIGNUM
	pub_n []*C.BIGNUM
	pri_d *C.BIGNUM
}
type Ring_Sign struct {
	// 定义环签名公开的信息
	n int
	pub_e []*C.BIGNUM
	pub_n []*C.BIGNUM
	rd []*C.BIGNUM
	sign *C.BIGNUM
}
func generate_rk(rk *Ring_Keys,n int,z int,e_list []*string,n_list []*string,d string){
	//生成环签名者的密钥
	rk.n=n
	rk.z=z
	for i:=0;i<n;i++{
		var tmpchar *C.char
		var tmpchar2 *C.char
		tmpchar=C.CString(*e_list[i])
		C.BN_hex2bn(&rk.pub_e[i], tmpchar);
		tmpchar2=C.CString(*n_list[i])
		C.BN_hex2bn(&rk.pub_n[i], tmpchar2);
	}
	rk.pri_d=C.BN_new()
	C.BN_hex2bn(rk.pri_d,d);
}
func free_rk(rk *Ring_Keys){
	// 释放环签名密钥空间
	for i:=0;i<rk.n;i++{
		C.BN_clear_free(rk.pub_e[i]);
		C.BN_clear_free(rk.pub_n[i]);
	}
	C.BN_clear_free(rk.pri_d);
}
func generate_rs(rs *Ring_Sign,n int,n_list []string,e_list []string,rd []string,sign string){
	// 生成签名信息
	rs.n=n;
	for i:=0;i<n;i++{
		C.BN_hex2bn(rs.pub_e[i],goStr2Cchar(e_list[i]));
		C.BN_hex2bn(rs.pub_n[i],goStr2Cchar(n_list[i]));
		C.BN_hex2bn(rs.rd[i],goStr2Cchar(rd[i]));
	}
	C.BN_hex2bn(rs.sign,goStr2Cchar(sign));
}
func free_rs(rs *Ring_Sign){
	// 释放签名信息
	for i:=0;i<rs.n;i++{
		C.BN_clear_free(rs.pub_e[i]);
		C.BN_clear_free(rs.pub_n[i]);
		C.BN_clear_free(rs.rd[i]);
	}
	C.BN_clear_free(rs.sign);
}

func E(res *C.BIGNUM,x *C.BIGNUM,msg *C.BIGNUM){
	// 使用SM3签名算法进行签名
	var str1 string
	var str2 string
	str1=C.GoString(C.BN_bn2dec(x))
	str2=C.GoString(C.BN_bn2dec(msg))
	str1=str1+str2
	SM3_Sign_Message(res,str1)

}
func g(res *C.BIGNUM,x *C.BIGNUM,e *C.BIGNUM,n *C.BIGNUM){
	//
	var bn_ctx *C.BN_CTX;
	bn_ctx=C.BN_CTX_new();
	var t1 *C.BIGNUM;
	var t2 *C.BIGNUM;
	var t3 *C.BIGNUM;
	var t4 *C.BIGNUM;
	var t5 *C.BIGNUM;
	var t6 *C.BIGNUM;
	t1=C.BN_new();
	t2=C.BN_new();
	t3=C.BN_new();
	t4=C.BN_new();
	t5=C.BN_new();
	t6=C.BN_new();

	C.BN_div(t1, t2, x, n, bn_ctx);
	C.BN_set_word(t3,1);
	C.BN_add(t4, t3, t1);
	C.BN_mul(t5, t4, n, bn_ctx);
	C.BN_lshift(t4, t3, RSA_NUM);
	C.BN_sub(t6, t4, t3);

	if C.BN_cmp(t5, t6) <= 0{
		C.BN_mul(t5, t1, n, bn_ctx);
		C.BN_mod_exp(t6, t2, e, n, bn_ctx);
		C.BN_add(res, t5, t6);
	}else{
		C.BN_copy(res, x);
	}
	C.BN_CTX_free(bn_ctx);
	C.BN_clear_free(t1);
	C.BN_clear_free(t2);
	C.BN_clear_free(t3);
	C.BN_clear_free(t4);
	C.BN_clear_free(t5);
	C.BN_clear_free(t6);
}

func  BN_xor(z *C.BIGNUM,x *C.BIGNUM,y *C.BIGNUM)  {
	// 对于两个BIGNUM的数组进行异或操作
	var l1 int;
	l1=int(C.strlen(C.BN_bn2hex(x)) / 2);
	var l2 int;
	l2=int(C.strlen(C.BN_bn2hex(y)) / 2);
	var t1 [2100]C.char;
	var t2 [2100]C.char;
	var t3 [2100]C.char;
	C.BN_bn2bin(x, &t1[0]);
	C.BN_bn2bin(y, &t2[0]);

	var num int;
	if l1>l2{
		num=l2-1;
		for i:=l1-1;i>=0;i--{
			if num>=0{
				t3[i]=t1[i]^t2[num];
				num--;
			}else {
				t3[i]=t1[i]
			}
		}
	}else {
		num=l1-1;
		for i:=l2-1;i>=0;i--{
			if num>=0{
				t3[i]=t1[num]^t2[i]
				num--
			}else {
				t3[i] = t2[i];
			}
		}
		l1=l2
	}
	C.BN_bin2bn(t3, l1, z);
}

func sign(m string,rs *Ring_Sign,rk *Ring_Keys){
	// 使用环签名密钥对于信息进行签名并保存在环签名的信息中
	var bn_ctx *C.BN_CTX;
	bn_ctx=C.BN_CTX_new();
	var msg_int *C.BIGNUM;
	msg_int=C.BN_new();
	SM3_Sign_Message(msg_int, m);
	var large *C.BIGNUM;
	large=C.BN_new();
	var temp *C.BIGNUM;
	temp=C.BN_new();
	C.BN_set_word(temp, 1);
	C.BN_lshift(large, temp, RSA_NUM);
	for i:=0;i<rk.n;i++{
		rs.rd[i]=C.BN_new();
		if i!=rk.z{
			C.BN_rand_range(rs.rd[i], large);
		}
	}
	var u *C.BIGNUM;
	u=C.BN_new();
	C.BN_rand_range(u, large);

	var c *C.BIGNUM;
	var v *C.BIGNUM;
	var e *C.BIGNUM;
	c=C.BN_new();
	v=C.BN_new();
	e=C.BN_new();

	E(c,u,msg_int);
	C.BN_copy(v, c);

	count:=1;
	var i int;
	i=(rk.z+1)%rk.n;
	for ;count<rk.n;count++{
		g(e,rs.rd[i],rk.pub_e[i],rk.pub_n[i]);
	}

	BN_xor(temp, v, u);

	rs.n=rk.n;
	for i:=0;i<rk.n;i++{
		rs.pub_e[i]=C.BN_new();
		rs.pub_n[i]=C.BN_new();
		C.BN_copy(rs.pub_e[i],rk.pub_e[i]);
		C.BN_copy(rs.pub_n[i],rk.pub_n[i]);
	}
	C.BN_CTX_free(bn_ctx);
	C.BN_clear_free(temp);
	C.BN_clear_free(large);
	C.BN_clear_free(c);
	C.BN_clear_free(v);
	C.BN_clear_free(e);
	C.BN_clear_free(u);
}

func verify(m *string,rs *Ring_Sign)int{
	// 对于环签名信息进行验证，正确返回零否则返回1
	var bn_ctx C.BN_CTX;
	bn_ctx=C.BN_CTX_new();
	var msg_int C.BIGNUM;
	msg_int=C.BN_new();
	SM3_Sign_Message(msg_int, m);
	var r *C.BIGNUM;
	r=C.BN_new();
	var y [...]*C.BIGNUM;
	for i:=0;i<rs.n;i++{
		y[i]=C.BN_new();
		g(y[i],rs.rd[i],rs.pub_e[i],rs.pub_n[i]);
	}

	var t *C.BIGNUM;
	t=C.BN_new();
	var middle *C.BIGNUM;
	middle=C.BN_new();
	C.BN_copy(middle, rs.sign);

	for i:=0;i<rs.n;i++{
		BN_xor(t, middle, y[i]);
		E(r, t, msg_int);
		C.BN_copy(middle, r);
	}

	C.BN_clear_free(t);
	C.BN_clear_free(middle);
	for i:=0;i<rs.n;i++{
		C.BN_clear_free(y[i]);
	}
	C.BN_CTX_free(bn_ctx);
	if C.BN_cmp(r, rs.sign)==0{
		C.BN_clear_free(r);
		return 1;
	}else {
		C.BN_clear_free(r);
		return 0;
	}
}

func SM3_Sign_Message(res *C.BIGNUM,m string){
	// 使用SM3算法对于铭文进行签名并保存签名结果
	var msg_ctx C.sm3_ctx_t;
	var md string;
	C.sm3_init(&msg_ctx);
	C.sm3_update(&msg_ctx, m, C.strlen(m));
	C.sm3_final(&msg_ctx, md);
	C.BN_bin2bn(md, 32, res);
}