import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {
    // 这个最快的居然是一个简简单单对DFS
    // 居然有这个，加上一个标志的flag
    // 判断时候如果上一个没有被用说明上一个的情况已经和这个相似于是就不管从而剪枝
    public void dfs(int[] nums,int nowpos,List<List<Integer>> res){
        if (nowpos==nums.length){
            List<Integer> thelist=new ArrayList<>();
            for (int i:nums)
                thelist.add(i);
            // 开始没有加这个出错了 ，但是还是难以想象错在哪
            if (res.contains(thelist)){
                System.out.println(thelist);
                return;
            }
            res.add(thelist);
            return;
        }
        for (int i=nowpos;i<nums.length;i++){
            // 这个地方的剪枝无法保证后面某个替换之后他后面的相同的不被替换
            if (nums[nowpos]==nums[i]&&i!=nowpos)
                continue;
            if (i!=nowpos&&i>0&&nums[i]==nums[i-1])
                continue;
            if (i==nowpos){
                dfs(nums,nowpos+1,res);
                continue;
            }
            int tmpnum=nums[nowpos];
            nums[nowpos]=nums[i];
            nums[i]=tmpnum;
            dfs(nums,nowpos+1,res);
            nums[i]=nums[nowpos];
            nums[nowpos]=tmpnum;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(nums,0,res);
        return res;
    }
    public static void main(String[] args){
        int[] list={-1,2,0,-1,1,0,1};
        Leetcode47 lc=new Leetcode47();
        lc.permuteUnique(list);
//        System.out.println(lc.permuteUnique(list));
    }
}
