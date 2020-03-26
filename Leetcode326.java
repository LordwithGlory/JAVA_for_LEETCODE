public class Leetcode326 {
    public boolean isPowerOfThree(int n) {
        // 最快的return n > 0 && 1162261467 % n == 0;
        // 那个数字是int中3的最高次方
        int base=1;
        while (base<n&&base<Integer.MAX_VALUE/3)
            base*=3;
        return base==n;
    }
}
