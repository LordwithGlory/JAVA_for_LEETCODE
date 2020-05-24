public class Weekly_5419 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int numone=nums1[0];
        int onemax=Integer.MAX_VALUE;
        int numtwo=nums2[0];
        int twomin=Integer.MIN_VALUE;
        boolean[] oneflag=new boolean[2];
        oneflag[0]=true;
        oneflag[1]=true;
        for (int num:nums1){
            if (num*numone<=0){
                oneflag[0]=false;
                break;
            }
            if (numone<0)
                twomin=Math.max(num,twomin);
            else if (numone>0)
                onemax=Math.min(onemax,num);
        }
        for (int num:nums2){
            if (num*numtwo<=0){
                oneflag[1]=false;
                break;
            }
            if (numtwo<0)
                twomin=Math.max(num,twomin);
            else if (numtwo>0)
                onemax=Math.min(onemax,num);
        }
        if (numone*numtwo<0&&oneflag[0]&&oneflag[1])
            return onemax*twomin;
        int[][] allcount=new int[nums1.length+1][nums2.length+1];
        int res=nums1[0]*nums2[0];
        for (int row=1;row<=nums1.length;row++){
            for (int col=1;col<=nums2.length;col++){
                int temp=nums1[row-1]*nums2[col-1];
                allcount[row][col]=temp;
                // 开始少考虑了一个方向
                allcount[row][col]=Math.max(allcount[row][col-1],allcount[row-1][col-1]+temp);
                allcount[row][col]=Math.max(allcount[row][col],allcount[row-1][col]);
                res=Math.max(res,allcount[row][col]);
            }
        }
        return res;
    }
}
