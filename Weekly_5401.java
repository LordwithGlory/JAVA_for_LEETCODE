public class Weekly_5401 {
    public boolean kLengthApart(int[] nums, int k) {
        int lens=nums.length;
        int former=Integer.MIN_VALUE;
        boolean res=true;
        for (int pos=0;pos<lens&&res;pos++){
            if (nums[pos]==0)
                continue;
            if (former<0){
                former=pos;
                continue;
            }
            if (pos-former-1<k)
                res=false;
            former=pos;
        }
        return res;
    }
}
