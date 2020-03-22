public class Leetcode191 {
    public int hammingWeight(int n) {
        int res=0;
//        while (n>0){
//            int tmp=n&1;
//            if (tmp==1)
//                res++;
//            n/=2;
//        }
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
//        return res;
    }

    public static void main(String[] args){
        int n=Integer.MAX_VALUE;
        Leetcode191 lc=new Leetcode191();
        lc.hammingWeight(n);
    }
}
