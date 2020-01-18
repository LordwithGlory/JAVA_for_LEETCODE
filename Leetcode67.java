public class Leetcode67 {
    public String addBinary(String a, String b) {
        // 不同进制转换https://blog.csdn.net/Evan123mg/article/details/45371903
//        int bina=Integer.valueOf(a,2);
//        int binb=Integer.valueOf(b,2);
//        int res=bina+binb;
//        return Integer.toBinaryString(res);
        int lenb=b.length()-1;
        int lena=a.length()-1;
        String res=new String();
        int addnum=0;
        for (;lena>=0||lenb>=0;lena--,lenb--){
            if (lena>=0)
                addnum+=a.charAt(lena)-'0';
            if (lenb>=0)
                addnum+=b.charAt(lenb)-'0';
            if (addnum%2==0)
                res="0"+res;
            if (addnum%2==1)
                res="1"+res;
            addnum/=2;
        }
        while (addnum!=0){
            if (addnum%2==0)
                res="0"+res;
            if (addnum%2==1)
                res="1"+res;
            addnum/=2;
        }
        return res;
        // 最快速答案里面一些有意思的代码
//        int n = a.length(),m = b.length();
//        if(n < m)
//            return addBinary(b,a);
        // 答案里面依旧是和我一样的的方法
        // 但是使用了StringBuilder这个类型
    }
}
