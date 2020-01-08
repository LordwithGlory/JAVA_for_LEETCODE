import java.util.*;

public class Leetcode39 {
    // 可能是因为使用stack所以比较慢
    // 快的方法使用下标进行剪纸操作
        public void dfs(int lens,int[] nums, Stack<Integer> onelist,List<List<Integer>> res,int target){
        if (target==0){
            if (onelist.isEmpty()){
                return;
            }
            res.add(new ArrayList<Integer>(onelist));
            return;
        }
        for (int i=0;i<lens;i++){
            if (nums[i]<onelist.peek())
                continue;
            if (nums[i]>target)
                break;
            onelist.add(nums[i]);
            dfs(lens,nums,onelist,res,target-nums[i]);
            onelist.pop();
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        Stack<Integer> q=new Stack<Integer>();
        int lens=candidates.length;
        for (int i=0;i<lens;i++){
            q.clear();
            q.push(candidates[i]);
            dfs(lens,candidates,q,res,target-candidates[i]);
        }
        return res;
    }
    public static void main(String[] args){
        int[] can={2,3,6,7};
        int target=7;
        Leetcode39 lc=new Leetcode39();
        System.out.println(lc.combinationSum(can,target));
    }
}
