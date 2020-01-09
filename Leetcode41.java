import java.util.HashSet;
import java.util.Set;

public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> myset=new HashSet<Integer>();
        int min=1;
        for(int i:nums){
            if (myset.contains(i))
                continue;
            myset.add(i);
            if (i==min){
                while (myset.contains(min))
                    min++;
            }
        }
        return min;
    }
}
