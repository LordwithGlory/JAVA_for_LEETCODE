public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        if (nums.length<2)
            return;
        k%=nums.length;
        if (k==0)
            return;
        boolean[] isright=new boolean[nums.length];
        // 最快的设置了一个count和一个start
        // count到头时候就结束了
        for (int pos=0;pos<nums.length;pos++){
            int nextpos=(pos+k)%nums.length;
            int former=nums[pos];
            while (!isright[nextpos]){
                isright[nextpos]=true;
                int tmp=nums[nextpos];
                nums[nextpos]=former;
                former=tmp;
                nextpos=(nextpos+k)%nums.length;
            }
        }
        return;
    }
}
