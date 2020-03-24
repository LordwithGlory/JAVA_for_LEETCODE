import java.util.Arrays;

public class Leetcode209 {
//    private int minsub(int target,int[] nums,int rightpos){
    // 这个贪心写的还行
//        int right=rightpos-1;
//        while (right>=0&&nums[right]>target)
//            right--;
//        if (right<0)
//            return 0;
//        if (nums[right]==target)
//            return 1;
//        int res=0;
//        res=minsub(target-nums[right],nums,right);
//        if (res!=0)
//            return res+1;
//        return res;
//    }
    public int minSubArrayLen(int s, int[] nums) {
//        if (nums==null||nums.length==0)
//            return 0;
//        Arrays.sort(nums);
//        return minsub(s,nums,nums.length);
        // 这个应该是应对的子串
        int leftpos=0;
        int sum=0;
        int res=nums.length+1;
        for (int rightpos=0;rightpos<nums.length;rightpos++){
            sum+=nums[rightpos];
            if (sum==s)
                res=Integer.min(res,rightpos-leftpos+1);
            else if (sum>s){
                while (sum>=s&&leftpos<=rightpos){
                    res=Integer.min(res,rightpos-leftpos+1);
                    sum-=nums[leftpos];
                    leftpos++;
                }
            }
        }
        if (res>nums.length)
            return 0;
        return res;
    }

    public static void main(String[] args){
        int s=11;
        int[] array={1,2,3,4,5};
        Leetcode209 lc=new Leetcode209();
        lc.minSubArrayLen(s,array);
    }
}
