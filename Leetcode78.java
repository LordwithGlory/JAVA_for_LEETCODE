import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public void dfs(int[] nums,int lastviewed,List<Integer> onelist,List<List<Integer>> res){
        res.add(new ArrayList<>(onelist));
        for (int i=lastviewed+1;i<nums.length;i++){
            onelist.add(nums[i]);
            dfs(nums,i,onelist,res);
            onelist.remove(onelist.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> oneres=new ArrayList<Integer>();
        dfs(nums,-1,oneres,res);
        return res;
    }
}
