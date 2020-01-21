public class Leetcode70 {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        if (n==1)
            return 1;
        else if (n==2)
            return 2;
        dp[n-1]=1;
        dp[n-2]=1;
        for (int i=n-3;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
}
