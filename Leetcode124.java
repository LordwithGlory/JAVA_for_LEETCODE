public class Leetcode124 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int magnum=Integer.MIN_VALUE;
    public int macbeth(TreeNode root){
        int left=0;
        int right=0;
        if (root.left!=null)
            left= macbeth(root.left);
        if (root.right!=null)
            right= macbeth(root.right);
        int sum=root.val;
        if (left>0)
            sum+=left;
        if (right>0)
            sum+=right;
        if (sum>magnum)
            magnum=sum;
        sum=root.val;
        if (left>right&&left>0)
            sum+=left;
        else if (right>=left&&right>0)
            sum+=right;
        return sum;
    }
    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
        magnum=root.val;
        macbeth(root);
        return magnum;
    }
}
