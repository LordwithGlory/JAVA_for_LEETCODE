public class Leetcode55 {
    public boolean canJump(int[] nums) {
        // 这个写的就是憨批
        // 人家那个才是真的高
        boolean[] res=new boolean[nums.length];
        int pos=nums.length-1;
        res[pos--]=true;
        while (pos>=0){
            int len=nums[pos];
            for (int i=1;i<=len&&!res[pos];i++){
                if (pos+i>nums.length-1)
                    break;
                res[pos]=res[pos+i];
            }
            pos--;
        }
        return res[0];
    }
    public boolean can(int[] nums){
        boolean[] res=new boolean[nums.length];
        int pos=nums.length-1;
        int lefmax=pos;
        res[pos--]=true;
        while (pos>=0){
            if (pos+nums[pos]>=lefmax){
                res[pos]=true;
                lefmax=pos;
            }
            pos--;
        }
        return res[0];
    }
}
