import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if (root==null)
            return res;
        if (root.left!=null)
            res=inorderTraversal(root.left);
        res.add(root.val);
        if (root.right!=null){
            List<Integer> right=inorderTraversal(root.right);
            for (int one:right)
                res.add(one);
        }
        return res;
    }
}
