public class Leetcode109 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }
    public TreeNode sortedListToB(ListNode head,int len){
        if (len==0)
            return null;
        if (len==1)
            return new TreeNode(head.val);
        int leftlen=len/2;
        ListNode head_right=head;
        for (int i=0;i<leftlen;i++){
            head_right=head_right.next;
        }
        TreeNode root=new TreeNode(head_right.val);
        root.left=sortedListToB(head,leftlen);
        root.right=sortedListToB(head_right.next,len-leftlen-1);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode head_cp=head;
        int count=0;
        while (head_cp!=null){
            count++;
            head_cp=head_cp.next;
        }
        return sortedListToB(head,count);
    }
}
