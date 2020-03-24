public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        while (n>0){
            if (n==1)
                return true;
            if (n%2==1)
                return false;
            n>>=1;
        }
        return false;
    }
}
