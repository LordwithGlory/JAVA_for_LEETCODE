import java.util.HashSet;
import java.util.Set;

public class Leetcode137 {
    public int singleNumber(int[] nums) {
        // 最快那个还是用的位运算。。。
        Set<Integer> once=new HashSet<>();
        Set<Integer> more=new HashSet<>();
        for (int num:nums){
            if (once.contains(num)){
                more.add(num);
                once.remove(num);
            }else if (more.contains(num))
                continue;
            else
                once.add(num);
        }
        for (int n: once)
            return n;
        return -1;
    }
}
