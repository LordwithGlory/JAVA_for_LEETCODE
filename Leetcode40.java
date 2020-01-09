import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    // 更快的答案中把递归开始就设施为i=0的地方就是for循坏开始的时候
    // 这样减少了查找和设置值的问题
    // 所以传参的时候加了一个index参数
    public void dfs(int lens,List<Integer> onelist,List<List<Integer>> res,int target,int[] nums){
        if (target==0&&!res.contains(onelist)){
            res.add(new ArrayList<>(onelist));
            return;
        }
        // 这个地方进行去重操作，每次都在for循环中加一个检验保证和上一个元素不一样
        // 但是dfs的时候无论下一个元素和本元素是否一样都会进行操作
        // 所以能够保证一个序列里面可以存在多个相同元素
        for (int i=0;i<lens;i++){
            if (nums[i]==Integer.MAX_VALUE||onelist.get(0)<nums[i])
                continue;
            if (nums[i]>target&&nums[i]!=Integer.MAX_VALUE)
                break;
            int tmpnum=nums[i];
            nums[i]=Integer.MAX_VALUE;
            onelist.add(0,tmpnum);
            dfs(lens,onelist,res,target-tmpnum,nums);
            onelist.remove(0);
            nums[i]=tmpnum;
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        // 似乎可以不去排列一会试试
        Arrays.sort(candidates);
        List<Integer> onelist=new ArrayList<Integer>();
        int lens=candidates.length;
        for (int i=0;i<lens;i++){
            if (i!=0&&candidates[i]==candidates[i-1])
                continue;
            int tmpnum=candidates[i];
            candidates[i]=Integer.MAX_VALUE;
            onelist.add(0,tmpnum);
            dfs(lens,onelist,res,target-tmpnum,candidates);
            candidates[i]=tmpnum;
            onelist.remove(0);
        }
        return res;
    }
}
