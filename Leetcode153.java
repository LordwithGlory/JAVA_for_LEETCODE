public class Leetcode153 {
    public int findMin(int[] nums) {
        if (nums.length==0)
            return 0;
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (mid==nums.length-1)
                return nums[mid];
            if (mid==0)
                return Math.min(nums[1],nums[0]);
            if (nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1])
                return nums[mid];
            if (nums[mid]>=nums[left]&&nums[mid]>nums[right])
                left=mid+1;
            else if (nums[mid]<=nums[right]&&nums[mid]<nums[left])
                right=mid-1;
            else if (nums[mid]>nums[left]&&nums[mid]<nums[right])
                break;
        }
        return nums[left];
    }

    public static void main(String[] args){
        Leetcode153 lc=new Leetcode153();
        int[] nums={4,5,6,7,0};
        System.out.println(lc.findMin(nums));
    }
}
