public class Leetcode268 {
    public int missingNumber(int[] nums) {
        // 有一说一我觉得最快那个不如俺思考的
        // 他是计算了0-n的和，然后减去现在的和
        int res=0;
        for (int pos=0;pos<nums.length;pos++){
            res^=(pos+1);
            res^=nums[pos];
        }
        return res;
    }
}
