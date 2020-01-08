public class Leetcode33 {
    public int search(int[] nums, int target) {
        int right,left;
        right=nums.length-1;
        if (right==0){
            if (nums[0]==target)
                return 0;
            return -1;
        }
        left=0;
        while (left<right) {
            int mid = (left + right) / 2;
            if (target==nums[left])
                return left;
            else if (target==nums[mid])
                return mid;
            else if (target==nums[right])
                return right;
            if (target>nums[left]) {
                if (nums[mid]>nums[left]&&target>nums[mid]){
                    left=mid+1;
                }else if (nums[mid]>nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else if (nums[mid]<nums[left]){
                    right=mid-1;
                }else {
                    // 开始时候没有考虑这个地方导致逻辑上有缺失
                    // 对于这个例如例子[1,3],2
                    return -1;
                }
            } else if (target<nums[right]) {
                if (target>nums[mid]){
                    left=mid+1;
                }else if (nums[mid]>nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {
                return -1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Leetcode33 l3=new Leetcode33();
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(l3.search(nums,target));
    }
}
