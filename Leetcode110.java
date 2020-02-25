public class Leetcode110 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public boolean thebalece(TreeNode root,int[] hegith){
        // 如果想修改值的话必须使用传地址操作
        // 最快的那个设置了全局变量true false。。。
        hegith[0]=0;
        if (root==null)
            return true;
        int[] lefthigh=new int[1];
        int[] righthigh=new int[1];
        boolean res=thebalece(root.left,lefthigh)&&thebalece(root.right,righthigh);
        if (!res)
            return res;
        if (lefthigh[0]-righthigh[0]>1||lefthigh[0]-righthigh[0]<-1){
            res=false;
            hegith[0]=0;
            return res;
        }
        hegith[0]=Math.max(lefthigh[0],righthigh[0])+1;
        return res;
    }
    public boolean isBalanced(TreeNode root) {
        int[] thehigh=new int[1];
        return thebalece(root,thehigh);
    }
}
