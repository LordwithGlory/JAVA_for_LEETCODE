public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<k||k==0)
            return null;
        if (k==1)
            return nums;
        int maxnum=nums[0];
        int maxpos=0;
        int respos=0;
        int[] res=new int[nums.length-k+1];
        for (int pos=0;pos<nums.length;pos++){
            if (nums[pos]>=nums[maxpos]){
                maxpos=pos;
                maxnum=nums[pos];
            }
            if (pos<k-1)
                continue;
            if (maxpos<=pos-k){
                maxpos=pos-k+1;
                maxnum=nums[maxpos];
                for (int i=maxpos+1;i<=pos;i++){
                    if (nums[i]>=maxnum){
                        maxnum=nums[i];
                        maxpos=i;
                    }
                }
            }
            res[respos]=maxnum;
            respos++;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums={4,-2};
        int k=2;
        Leetcode239 lc=new Leetcode239();
        lc.maxSlidingWindow(nums,k);
    }
}
