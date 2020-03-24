import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> int_pos=new HashMap<>();
        for (int pos=0;pos<nums.length;pos++){
            int now=nums[pos];
            if (int_pos.containsKey(now)){
                if (int_pos.get(now)>=pos-k)
                    return true;
            }
            int_pos.put(now,pos);
        }
        return false;
    }
}
