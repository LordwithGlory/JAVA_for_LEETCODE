public class Leetcode61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return head;
        int listlen=1;
        ListNode tmphead=head;
        while (tmphead.next!=null){
            listlen++;
            tmphead=tmphead.next;
        }
        tmphead.next=head;
        k%=listlen;
        k=listlen-k;
        while (k>0){
            tmphead=tmphead.next;
            k--;
        }
        head=tmphead.next;
        tmphead.next=null;
        return head;
    }
}
