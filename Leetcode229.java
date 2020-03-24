import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        // 最快的那个显示我们的list最多有两个因此这个就有点意思了
        List<Integer> res=new ArrayList<>();
        if (nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        int internal=nums.length/3;
        for (int pos=0;pos<nums.length*2/3+1;pos++){
            if (nums[pos]==nums[pos+internal]){
                if (res.contains(nums[pos]))
                    continue;
                res.add(nums[pos]);
                pos+=internal;
            }
        }
        return res;
    }
}
