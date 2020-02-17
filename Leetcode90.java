import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public List<List<Integer>> oneway(int[] nums,int begin){
        // 较快的那个把每一条list都作为参数传输
        List<List<Integer>> oneres=new ArrayList<List<Integer>>();
        List<Integer> one=new ArrayList<Integer>();
        if (begin!=-1)
            one.add(nums[begin]);
        oneres.add(new ArrayList<Integer>(one));
        for (int i=begin+1;i<nums.length;i++){
            if (i!=begin+1&&i>0&&nums[i]==nums[i-1])
                continue;
            List<List<Integer>> nextres=oneway(nums,i);
            for (List<Integer> res:nextres){
                if (begin!=-1)
                    res.add(0,nums[begin]);
                oneres.add(new ArrayList<>(res));
            }
        }
        return oneres;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        res=oneway(nums,-1);
        return res;
    }
}
