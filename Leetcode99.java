import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode99 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public void getNums(TreeNode root,List nums){
        if (root==null)
            return;
        nums.add(root.val);
        getNums(root.left,nums);
        getNums(root.right,nums);
    }
    public void setNums(TreeNode root,List<Integer> nums){
        if (root.left!=null)
            setNums(root.left,nums);
        root.val=nums.get(0);
        nums.remove(0);
        if (root.right!=null)r
            setNums(root.right,nums);
    }
    public void recoverTree(TreeNode root) {
        if (root==null)
            return;
        List<Integer> nums=new ArrayList<>();
        getNums(root,nums);
        Collections.sort(nums);

        // 这个代码解决不了右侧某个节点小于根节点
//        if (root==null)
//            return;
//        int rootv=root.val;
//        if (root.left!=null){
//            int leftv=root.left.val;
//            if (leftv>rootv){
//                root.val=leftv;
//                root.left.val=rootv;
//                rootv=leftv;
//            }
//            recoverTree(root.left);
//        }
//        if (root.right!=null){
//            int rightv=root.right.val;
//            if (rootv>rightv){
//                root.val=rightv;
//                root.right.val=rootv;
//                rootv=rightv;
//            }
//            recoverTree(root.right);
//        }
//        boolean res=true;
//        if (root.left!=null&&root.val<root.left.val)
//            res=false;
//        if (res&&root.right!=null&&root.val>root.right.val)
//            res=false;
//        if (!res)
//            recoverTree(root);
    }
}
