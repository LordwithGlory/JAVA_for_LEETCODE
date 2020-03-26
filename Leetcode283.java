public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int viewpos=0;
        int endzeropos=0;
        for (;viewpos<nums.length;viewpos++){
            if (nums[viewpos]!=0){
                nums[endzeropos]=nums[viewpos];
                endzeropos++;
            }
        }
        while (endzeropos<nums.length)
            nums[endzeropos]=0;
    }
}
