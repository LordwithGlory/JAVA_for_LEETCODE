public class Leetcode112 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        if (root.right==null && root.left==null && sum==root.val)
            return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
