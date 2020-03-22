public class Leetcode198 {
    public int rob(int[] nums) {
        // 最快的那个DP只考虑自己和相邻节点
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        int res=0;
        if (nums.length==0)
            return 0;
        else if (nums.length==1)
            return nums[0];
        int pos=nums.length-1;
        while (pos>=0){
            int tmp=nums[pos];
            if (pos+2<nums.length)
                tmp+=nums[pos+2];
            if (pos+3<nums.length)
                tmp=Math.max(tmp,nums[pos]+nums[pos+3]);
            nums[pos]=tmp;
            res=Math.max(res,tmp);
        }
        return res;
    }
}
