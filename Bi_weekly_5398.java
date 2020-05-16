public class Bi_weekly_5398 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public int goodNodes(TreeNode root) {
        if (root==null)
            return 0;
        int res=1;
        int leftnum=0;
        int rightnum=0;
        if (root.left!=null&&root.left.val<root.val){
            root.left.val=root.val;
            leftnum=goodNodes(root.left)-1;
        }else if (root.left!=null)
            leftnum=goodNodes(root.left);
        if (root.right!=null&&root.right.val<root.val){
            root.right.val=root.val;
            rightnum=goodNodes(root.right)-1;
        }else if (root.right!=null)
            rightnum=goodNodes(root.right);
        res+=leftnum+rightnum;
        return res;
    }
}
