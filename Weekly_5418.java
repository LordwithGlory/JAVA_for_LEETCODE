import java.util.HashSet;
import java.util.Set;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

public class Weekly_5418 {

    private int findPath(TreeNode root,Set<Integer> pathvals){
        if (pathvals.contains(root.val))
            pathvals.remove(root.val);
        else
            pathvals.add(root.val);
        int res=0;
        if (root.left==null&&root.right==null){
            if (pathvals.size()<2)
                res= 1;
        }
        if (root.left!=null)
            res=findPath(root.left,pathvals);
        if (root.right!=null)
            res+=findPath(root.right,pathvals);
        if (pathvals.contains(root.val))
            pathvals.remove(root.val);
        else
            pathvals.add(root.val);
        return res;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> pathvals=new HashSet<>();
        return findPath(root,pathvals);
    }

    public static void main(String[] args){
        Weekly_5418 lc=new Weekly_5418();
        TreeNode root=new TreeNode(2,new TreeNode(3,new TreeNode(3),new TreeNode(1)),new TreeNode(1,null,new TreeNode(1)));
        System.out.println(lc.pseudoPalindromicPaths(root));
    }
}
