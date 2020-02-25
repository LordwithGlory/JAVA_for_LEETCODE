import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public void path(TreeNode root,int sum,List<List<Integer>> res,List<Integer> onelist){
        if (root.left==null&&root.right==null&&root.val==sum){
            onelist.add(root.val);
            res.add(new ArrayList<>(onelist));
            onelist.remove(onelist.size()-1);
            return;
        }
        onelist.add(root.val);
        if (root.left!=null){
            path(root.left,sum-root.val,res,onelist);
        }
        if (root.right!=null){
            // 开始时候忘记写.right 导致栈溢出
            path(root.right,sum-root.val,res,onelist);
        }
        onelist.remove(onelist.size()-1);
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> oneres=new ArrayList<Integer>();
        if (root==null)
            return res;
        path(root,sum,res,oneres);
        return res;
    }
    public static void main(String[] args){
        Leetcode113 lc=new Leetcode113();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);
        System.out.println(lc.pathSum(root,22));
    }
}
