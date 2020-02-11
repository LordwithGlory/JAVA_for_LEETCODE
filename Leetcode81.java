public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        // 费脑阔
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target)
                return true;
            if (nums[mid]>target){
                if (nums[left]<=target){
                    right=mid-1;
                }else {
                    if (nums[left]>nums[mid])
                        right=mid-1;
                    else if (nums[left]==nums[mid]){
                        left++;
                    }else
                        left=mid+1;
                }
            }else {
                if (nums[right]>=target){
                    left=mid+1;
                }else {
                    if (nums[mid]<nums[right])
                        right=mid-1;
                    else if (nums[mid]==nums[right])
                        right--;
                    else
                        left=mid+1;
                }
            }
        }
        return false;
    }
}
