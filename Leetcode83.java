public class Leetcode83 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode res=head;
        int former=res.val;
        while (head.next!=null){
            former=head.val;
            ListNode now=head;
            head=head.next;
            while (head!=null&&head.val==former)
                head=head.next;
            now.next=head;
        }
        return res;
    }
}
