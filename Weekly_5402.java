public class Weekly_5402 {
    public int longestSubarray(int[] nums, int limit) {
        int res=1;
//        int maxnum=nums[0];
//        int minnum=nums[0];
//        for (int num:nums){
//            maxnum=Math.max(num,maxnum);
//            minnum=Math.min(num,minnum);
//        }
//        if (maxnum-minnum)
        for (int pos=0;pos<nums.length;pos++){
            int minpos=pos;
            int maxpos=pos;
            // hhh比较时候加一个等于好就过了
            for (int mypos=pos+1;mypos<nums.length;mypos++){
                if (nums[maxpos]<=nums[mypos])
                    maxpos=mypos;
                if (nums[minpos]>=nums[mypos])
                    minpos=mypos;
                if (nums[maxpos]-nums[minpos]<=limit)
                    res=Math.max(mypos-pos+1,res);
                else
                    break;
            }
            pos=Math.min(maxpos,minpos);
        }
        return res;
    }
}
