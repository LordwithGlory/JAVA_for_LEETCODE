import java.util.List;

public class Leetcode203 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val)
            head=head.next;
        if (head==null)
            return null;
        ListNode res=head;
        while (head.next!=null){
            if (head.next.val==val){
                head.next=head.next.next;
                continue;
            }
            head=head.next;
        }
        return res;
    }
}
