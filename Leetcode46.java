import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode46 {
    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> onelist,int cons){
        if (cons==nums.length){
            res.add(new ArrayList<>(onelist));
            return;
        }
        for (int i:nums){
            if (onelist.contains(i))
                continue;
            onelist.add(i);
            dfs(nums,res,onelist,cons+1);
            onelist.remove(onelist.size()-1);
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        // 最快的方法居然是一个个对排序
        // 递归之后先排第一个再排第二个
        // 没想到那个速度有这么快？
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int len=nums.length;
        List<Integer> onelist=new Stack<>();
        for (int i:nums){
            onelist.add(i);
            dfs(nums,res,onelist,1);
            onelist.remove(onelist.size()-1);
        }
        return res;
    }
}
