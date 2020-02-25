public class Leetcode114 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public void flatten(TreeNode root) {
        // 这个是right方向
        if (root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        TreeNode tmproot=root;
        if (root.left!=null){
            tmproot=root.left;
            while (tmproot.right!=null)
                tmproot=tmproot.right;
            tmproot.right=root.right;
            root.right=root.left;
        }
        root.left=null;
        // 这个是left方向
//        if (root==null)
//            return;
//        flatten(root.left);
//        TreeNode tmproot=root;
//        while (tmproot.left!=null){
//            tmproot=tmproot.left;
//        }
//        flatten(root.right);
//        tmproot.left=root.right;
//        root.right=null;
    }
}
