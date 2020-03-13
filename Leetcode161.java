public class Leetcode161 {
    public int findPeakElement(int[] nums) {
        if (nums.length==1)
            return 0;
        int left=0;
        int righ=nums.length-1;
        if (nums[left]>nums[1])
            return 0;
        if (nums[righ]>nums[righ-1])
            return righ;
        while (left<righ&&nums[left]<=nums[left+1]){
            left++;
        }
        return left;
    }
}
