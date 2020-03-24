public class Leetcode206 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode res=null;
        while (head!=null){
            ListNode tmp=head.next;
            head.next=res;
            res=head;
            head=tmp;
        }
        return res;
    }
}
