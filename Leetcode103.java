import java.util.ArrayList;
import java.util.List;

public class Leetcode103 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public void getOrder(TreeNode root,int val,List<List<Integer>> res){
        if (root==null)
            return;
        if (res.size()<=val){
            res.add(new ArrayList<Integer>());
        }
        if (val%2==1){
            res.get(val).add(0,root.val);
        }else
            res.get(val).add(root.val);
        getOrder(root.left,val+1,res);
        getOrder(root.right,val+1,res);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        getOrder(root,0,res);
        return res;
    }
}
