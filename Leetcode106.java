import java.util.Arrays;

public class Leetcode106 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 最快的使用新建一个函数，然后参数是原来的数组以及他们的下标。。。
        if (postorder.length==1)
            return new TreeNode(postorder[0]);
        else if (postorder.length==0)
            return null;
        int rootval=postorder[postorder.length-1];
        int inpos=0;
        TreeNode root=new TreeNode(rootval);
        while (inorder[inpos]!=rootval)
            inpos++;
        int[] inleft= Arrays.copyOfRange(inorder,0,inpos);
        int[] inrght= Arrays.copyOfRange(inorder,inpos+1,inorder.length);
        int[] postlf= Arrays.copyOfRange(postorder,0,inpos);
        int[] postrt= Arrays.copyOfRange(postorder, inpos,postorder.length-1);
        root.left=buildTree(inleft,postlf);
        root.right=buildTree(inrght,postrt);
        return root;
    }
}
