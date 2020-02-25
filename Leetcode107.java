import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode107 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public void levelOrder(TreeNode root,int floor,List<List<Integer>> res){
        if (root==null)
            return;
        if (res.size()<=floor){
            res.add(new ArrayList<Integer>());
        }
        res.get(floor).add(root.val);
        levelOrder(root.left,floor+1,res);
        levelOrder(root.right,floor+1,res);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null)
            return res;
        levelOrder(root,0,res);
        Collections.reverse(res);
        return res;
    }
}
