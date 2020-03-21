public class Leetcode190 {
    public int reverseBits(int n) {
        int res=0;
        int count=0;
        while (count<32){
            count++;
            res=res<<1;
            res|=n&1;
            n=n>>1;
        }
        return res;
    }

    public static void main(String[] args){
        Leetcode190 lc=new Leetcode190();
        int n=Integer.MAX_VALUE-3;
        lc.reverseBits( n );
    }
}
