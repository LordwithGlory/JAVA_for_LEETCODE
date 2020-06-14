public class Weekly_5436 {
    public int[] runningSum(int[] nums) {
        for (int pos=1;pos<nums.length;pos++){
            nums[pos]+=nums[pos-1]+nums[pos];
        }
        return nums;
    }
}
