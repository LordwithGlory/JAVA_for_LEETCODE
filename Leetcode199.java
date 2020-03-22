import java.util.*;

public class Leetcode199 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public List<Integer> rightSideView(TreeNode root) {
        // 最快的用了辅助函数有level确定是哪一层
        List<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Queue<TreeNode> thefloor=new LinkedList<>();
        int floornum=1;
        thefloor.add(root);
        while (!thefloor.isEmpty()){
            int nextfloornum=0;
            while (floornum>0){
                floornum--;
                TreeNode now=thefloor.poll();
                if (floornum==0)
                    res.add(now.val);
                if (now.left!=null){
                    thefloor.add(now.left);
                    nextfloornum++;
                }
                if (now.right!=null){
                    thefloor.add(now.right);
                    nextfloornum++;
                }
            }
            floornum=nextfloornum;
        }
        return res;
    }
}
