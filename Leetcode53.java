public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        // 完全可以考虑不dp 虽然我也的确没有DP
        int res=Integer.MIN_VALUE;
        int[] dp=new int[nums.length];
        int pos=nums.length-1;
        res=dp[pos]=nums[pos];
        pos--;
        for (;pos>=0;pos--){
            dp[pos]=nums[pos];
            if (dp[pos+1]>0)
                dp[pos]+=dp[pos+1];
            if (res<dp[pos])
                res=dp[pos];
        }
        return res;
    }
}
