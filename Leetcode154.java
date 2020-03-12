public class Leetcode154 {
    public int findMin(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int left=0;
        int right=nums.length-1;
        while (left<right){
            while (left<right&&nums[left]==nums[right]){
                left++;
            }
            if (left==right)
                break;
            int mid=(left+right)/2;
            // 这个一个动一个不动的二分可还行
            if (nums[mid]<=nums[right])
                right=mid;
            else
                left=mid+1;
        }
        return nums[left];
    }

    public static void main(String[] args){
        Leetcode154 lc=new Leetcode154();
        int[] nums={3,1,3};
        System.out.println(lc.findMin(nums));
    }
}
