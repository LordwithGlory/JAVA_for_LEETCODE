import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 最快的那个是用的深搜设置层数，然后递归
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()){
            int qlen=q.size();
            List<Integer> mylist=new ArrayList<Integer>();
            while (qlen>0){
                qlen--;
                TreeNode one=q.poll();
                if (one.left!=null)
                    q.add(one.left);
                if (one.right!=null)
                    q.add(one.right);
                mylist.add(one.val);
            }
            res.add(mylist);
        }
        return res;
    }
}
