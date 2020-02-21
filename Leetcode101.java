public class Leetcode101 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public boolean symmetric(TreeNode left,TreeNode right){
        if (left==null && right==null)
            return true;
        if (left==null || right==null)
            return false;
        if (left.val!=right.val)
            return false;
        boolean res;
        res=symmetric(left.left,right.right)&&symmetric(left.right,right.left);
        return res;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if (root.left==null && root.right==null)
            return true;
        if (root.left==null || root.right==null)
            return false;
        if (root.left.val!=root.right.val)
            return false;
        return symmetric(root.left,root.right);
    }
}
