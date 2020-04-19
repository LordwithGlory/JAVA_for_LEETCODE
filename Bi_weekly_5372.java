public class Bi_weekly_5372 {
    public int minStartValue(int[] nums) {
        int npos=0;
        for (int num:nums){
            if (num<0)
                npos+=num;
        }
        if (npos==0)
            return 1;
        int right=1-npos;
        int left=1;
        while (left<right){
            int mid=(left+right)/2;
            int nowsum=mid;
            for (int num:nums){
                nowsum+=num;
                if (nowsum<1)
                    break;
            }
            if (nowsum<1)
                left=mid+1;
            else
                right=mid;
        }
        return right;
    }
}
