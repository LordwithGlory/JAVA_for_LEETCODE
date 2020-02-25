public class Leetcode108 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public TreeNode arraytoBst(int[] nums,int start,int len){
        if (start==len)
            return new TreeNode(nums[start]);
        if (start>len)
            return null;
        int rootpos=(start+len)/2;
        TreeNode root=new TreeNode(nums[rootpos]);
        root.left=arraytoBst(nums,start,rootpos-1);
        root.right=arraytoBst(nums,rootpos+1,len);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0)
            return null;
        int len=nums.length-1;
        return arraytoBst(nums,0,len);
    }
}
