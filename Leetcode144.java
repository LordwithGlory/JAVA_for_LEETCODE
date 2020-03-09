import java.util.*;

public class Leetcode144 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 最快的那群是狗吧说好不递归的你特娘的去递归了还。。。
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> mys=new Stack<>();
        Set<TreeNode> hasviewed=new HashSet<>();
        mys.add(root);
        if (root==null)
            return res;
        res.add(root.val);
        while (!mys.isEmpty()){
            TreeNode node=mys.peek();
            hasviewed.add(node);
            if (node.left!=null&&!hasviewed.contains(node.left)){
                res.add(node.left.val);
                mys.add(node.left);
            }else{
                node=mys.pop();
                if (node.right!=null){
                    res.add(node.right.val);
                    mys.add(node.right);
                }
            }
        }
        return res;
    }
}
