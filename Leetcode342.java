public class Leetcode342 {
    public boolean isPowerOfFour(int num) {
        // return ((num & (num-1)) == 0) && (num & 0xaaaaaaaa) == 0;
        // 最快的这个的确机智啊
        while (num>0){
            if (num==1)
                return true;
            int tmp=num&3;
            if (tmp!=0)
                return false;
            num>>=2;
        }
        return false;
    }
}
