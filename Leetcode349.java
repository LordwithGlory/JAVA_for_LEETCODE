import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 最快的那个先找出来最大最小的然后设置一个boolean数组先判断num1
        // 然后判断num2
        // 将最后结果保存在数组中（大小为num1和num2中最小的）
        // return Arrays.copyOf(res,k);
        if (nums1==null||nums2==null)
            return null;
        Set<Integer> set1=new HashSet<>();
        for (int num:nums1)
            set1.add(num);
        Set<Integer> set2=new HashSet<>();
        for (int num:nums2){
            if (set1.contains(num))
                set2.add(num);
        }
        int[] res=new int[set2.size()];
        int pos=0;
        for (int num:set2)
            res[pos++]=num;
        return res;
    }
}
