import java.util.*;

public class Leetcode145 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Set<TreeNode> hasvied=new HashSet<>();
        Stack<TreeNode> mys=new Stack<>();
        if (root==null)
            return res;
        mys.add(root);
        while (!mys.isEmpty()){
            TreeNode node=mys.peek();
            if (node.left!=null&&!hasvied.contains(node.left)){
                mys.add(node.left);
            }else if (node.right!=null&&!hasvied.contains(node.right))
                mys.add(node.right);
            else {
                mys.pop();
                hasvied.add(node);
                res.add(node.val);
            }
        }
        return res;
    }
}
