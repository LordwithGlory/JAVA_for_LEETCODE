public class Leetcode111 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if (left==0||right==0){
            return Math.max(left,right)+1;
        }
        return Math.min(left,right)+1;
    }
}
