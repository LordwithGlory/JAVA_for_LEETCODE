public class Leetcode328 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode res=head;
        ListNode restial=new ListNode(0);
        ListNode tail_cpy=restial;
        while (head!=null){
            ListNode tmp=head.next;
            if (tmp==null)
                break;
            head.next=tmp.next;
            restial.next=tmp;
            tmp.next=null;
            restial=restial.next;
            if (head.next==null)
                break;
            head=head.next;
        }
        head.next=tail_cpy.next;
        return res;
    }
}
