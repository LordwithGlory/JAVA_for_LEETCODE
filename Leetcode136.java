import java.util.HashSet;
import java.util.Set;

public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int num:nums)
            res^=num;
        return res;
//        Set<Integer> numset=new HashSet<>();
//        for (int num:nums){
//            if (numset.contains(num))
//                numset.remove(num);
//            else
//                numset.add(num);
//        }
//        for (int num:numset)
//            return num;
//        return -1;
    }
}
