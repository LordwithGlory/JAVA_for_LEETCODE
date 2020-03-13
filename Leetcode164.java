public class Leetcode164 {
    private class Bucket{
        int minnum=Integer.MAX_VALUE;
        int maxnum=Integer.MIN_VALUE;
    }
    public int maximumGap(int[] nums) {
        // 最快的那个狗是用的sort先排序的。。。
        if (nums.length<2)
            return 0;
        int minnum=nums[0];
        int maxnum=nums[0];
        for (int pos=1;pos<nums.length;pos++){
            minnum=Math.min(nums[pos],minnum);
            maxnum=Math.max(nums[pos],maxnum);
        }
        if (maxnum==minnum)
            return 0;
        int bucklen=(maxnum-minnum)/(nums.length-1);
        if (bucklen==0)
            bucklen=1;
        Bucket[] buck=new  Bucket[(maxnum-minnum)/bucklen+1];
        for (int num:nums){
            int pos=(num-minnum)/bucklen;
            if (buck[pos]==null)
                buck[pos]=new Bucket();
            buck[pos].maxnum=Math.max(num,buck[pos].maxnum);
            buck[pos].minnum=Math.min(num,buck[pos].minnum);
        }
        int res=0;
        int former=minnum;
        for (int pos=0;pos<buck.length;pos++){
            if (buck[pos]==null)
                continue;
            res=Math.max(buck[pos].minnum-former,res);
            res=Math.max(buck[pos].maxnum-buck[pos].minnum,res);
            former=buck[pos].maxnum;
        }
        return res;
        // 内存爆掉
//        int[] has_found=new int[maxnum-minnum+1];
//        for (int num:nums)
//            has_found[num-minnum]=1;
//        int res=0;
//        int lastfound=1;
//        for (int pos=1;pos<=maxnum-minnum;pos++){
//            if (has_found[pos]==1&&pos-lastfound>res)
//                res=pos-lastfound;
//            if (has_found[pos]==1)
//                lastfound=pos;
//        }
//        return res;
    }
}
