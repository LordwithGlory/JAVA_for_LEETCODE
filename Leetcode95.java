import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
    // 最快的那个很有意思在把左右这些都通过矩阵来存起来，
    // 因为存在重复计算操作
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public List<TreeNode> istTree(int begin,int end){
        List<TreeNode> oneres=new ArrayList<TreeNode>();
        if (begin==end){
            TreeNode tnode=new TreeNode(begin);
            oneres.add(tnode);
            return oneres;
        }else if (begin>end)
            return null;
        for (int i=begin;i<=end;i++){
            List<TreeNode> left=istTree(begin,i-1);
            List<TreeNode> rigt=istTree(i+1,end);
            if (i==begin){
                for (TreeNode oneright:rigt){
                    TreeNode now=new TreeNode(i);
                    now.left=null;
                    now.right=oneright;
                    oneres.add(now);
                }
            }else{
                for (TreeNode oneleft:left){
                    if (i==end){
                        TreeNode now=new TreeNode(i);
                        now.right=null;
                        now.left=oneleft;
                        oneres.add(now);
                        continue;
                    }
                    for (TreeNode oneright:rigt){
                        TreeNode now=new TreeNode(i);
                        now.left=oneleft;
                        now.right=oneright;
                        oneres.add(now);
                    }
                }
            }
        }
        return oneres;
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<TreeNode>();
        if (n==0)
            return res;
        return istTree(1,n);
    }
    public static void main(String[] agrs){
        Leetcode95 lc=new Leetcode95();
        lc.generateTrees(2);
    }
}
