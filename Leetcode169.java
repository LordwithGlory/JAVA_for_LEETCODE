import java.util.HashMap;
import java.util.Map;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        // hhh这个最快的是真的六批
//        Arrays.sort(nums);
//        return nums[nums.length/2];
        Map<Integer,Integer> thetimes=new HashMap<>();
        int lens=nums.length/2;
        for (int num:nums){
            int oldtime=thetimes.getOrDefault(num,0);
            oldtime+=1;
            if (oldtime>lens)
                return num;
            thetimes.put(num,oldtime);
        }
        return -1;
    }
}
