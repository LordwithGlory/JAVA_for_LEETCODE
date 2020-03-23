public class Leetcode201 {
    public int rangeBitwiseAnd(int m, int n) {
        // 最快的这个 的确啊如果不一样说明最后一位肯定是两个数字厉害了
//        int i = 0;
//        while(n > m) {
//            m >>>= 1;
//            n >>>= 1;
//            i++;
//        }
//
//        return n << i;
        int base=1;
        int res=0;
        int interval=n-m;
        if (m==0||n==0)
            return 0;
        while (base<=n){
            int tmp=n&base&m;
            if (tmp==0||interval>base){
                base<<=1;
                if (base>Integer.MAX_VALUE/2)
                    break;
                continue;
            }
            res|=base;
            if (base>Integer.MAX_VALUE/2)
                break;
            base<<=1;
        }
        return res;
    }
    public static void main(String[] args){
        int m=3;
        int n=5;
        Leetcode201 lc=new Leetcode201();
        System.out.println(lc.rangeBitwiseAnd(m,n));
    }
}
