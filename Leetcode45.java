public class Leetcode45 {
    public int jump(int[] nums) {
        // 可以不使用DP直接使用统计
        // maxReach = Math.max(maxReach, i+nums[i]);
        int[] steps=new int[nums.length];
        if (nums.length==1||nums.length==0)
            return 0;
        int pos=nums.length-1;
        steps[pos]=0;
        pos--;
        for (;pos>=0;pos--){
            steps[pos]=nums.length;
            int lens=nums[pos];
            if (lens>=nums.length-pos-1){
                steps[pos]=1;
                continue;
            }
            // 因为是最大跳不是唯一跳所以这个忽略了很多情况
//            steps[pos]=steps[pos+1]<steps[pos+lens]?steps[pos+1]:steps[pos+lens];
            for (int i=1;i<=lens;i++){
                // 状态转移方程
                steps[pos]=steps[pos+i]<steps[pos]?steps[pos+i]:steps[pos];
            }
            steps[pos]+=1;
        }
        return steps[0];
    }
}
