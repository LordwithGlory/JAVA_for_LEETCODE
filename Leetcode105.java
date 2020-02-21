import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode105 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0)
            return null;
        else if (preorder.length==1)
            return new TreeNode(preorder[0]);
        TreeNode root=new TreeNode(preorder[0]);
        int theval=preorder[0];
        int left=0;
        List<Integer> theleft=new ArrayList<Integer>();
        for (;left<inorder.length;left++){
            if (inorder[left]==theval)
                break;
            theleft.add(inorder[left]);
        }
        if (left==0){
            root.right=buildTree(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,1,inorder.length));
            return root;
        }else if (left==inorder.length-1){
            root.left=buildTree(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,0,left));
            return root;
        }
        int right=1;
        for (;right<preorder.length;right++){
            if (!theleft.contains(preorder[right]))
                break;
        }
        root.left=buildTree(Arrays.copyOfRange(preorder,1,right),Arrays.copyOfRange(inorder,0,left));
        root.right=buildTree(Arrays.copyOfRange(preorder,right,preorder.length),Arrays.copyOfRange(inorder,left+1,inorder.length));
        return root;
    }

    public static void main(String[] args){
        int[] preoder={3,2,1,4};
        int[] inorder={1,2,3,4};
        Leetcode105 lc=new Leetcode105();
        lc.buildTree(preoder,inorder);
    }
}
