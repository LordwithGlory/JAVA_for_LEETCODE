public class Weekly_5428 {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[nums.length];
        int left=0;
        int right=n;
        for (int pos=0;pos<n;pos++){
            res[pos*2]=nums[left++];
            res[2*pos+1]=nums[right++];
        }
        return res;
    }
}
