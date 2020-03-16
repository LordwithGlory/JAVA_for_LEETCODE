import java.util.ArrayList;
import java.util.List;

public class Leetcode173 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    private List<Integer> mylist=new ArrayList<>();
    private int wantedpos=0;
    private void construct(TreeNode root){
        if (root==null)
            return;
        construct(root.left);
        mylist.add(root.val);
        construct(root.right);
    }
    public Leetcode173(TreeNode root) {
        construct(root);
    }

    /** @return the next smallest number */
    public int next() {
        return mylist.get(wantedpos++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (wantedpos>=mylist.size())
            return false;
        return true;
    }
}
