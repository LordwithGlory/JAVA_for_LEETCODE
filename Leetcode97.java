import java.util.ArrayList;
import java.util.List;

public class Leetcode97 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public boolean isBST(TreeNode root, int min, int max, List<Integer> hasviewd){
        // 最快的那个狗不是用min 或者 max记载最大最小的而是使用的节点，初始化节电为null
        if (root==null)
            return true;
        boolean res=true;
        if (root.val>max||root.val<min|| hasviewd.contains(root.val))
            return false;
        if (root.left!=null && root.left.val>=root.val)
            return false;
        if (root.right!=null && root.right.val<=root.val)
            return false;
        hasviewd.add(root.val);
        res=isBST(root.left,min,max>root.val?root.val:max,hasviewd)&&isBST(root.right,min<root.val?root.val:min,max,hasviewd);
        return res;
    }
    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        List<Integer> hasviewed=new ArrayList<>();
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE,hasviewed);
    }
}
