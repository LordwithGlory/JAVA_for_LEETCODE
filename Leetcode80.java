public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int swappos;
        int scanpos;
        if (nums.length<3)
            return nums.length;
        // 原来不需要管其他的
        swappos=2;
        for (scanpos=2;scanpos<nums.length;scanpos++){
            if (nums[scanpos]==nums[swappos-2]){
                continue;
            }else {
                int tmpswap=nums[scanpos];
                nums[scanpos]=nums[swappos];
                nums[swappos]=tmpswap;
                swappos++;
                // 这边可以修改为,其他都不需要==
//                nums[swappos++]=nums[scanpos];
            }
        }
        return swappos;
    }
}
