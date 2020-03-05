public class Leetcode129 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    int res=0;
    public void sumtree(TreeNode root,int former){
        former*=10;
        former+=root.val;
        if (root.left==null && root.right==null){
            res+=former;
            return;
        }
        if (root.left!=null)
            sumtree(root.left,former);
        if (root.right!=null)
            sumtree(root.right,former);
        return;
    }
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return res;
        sumtree(root,0);
        return res;
    }
}
