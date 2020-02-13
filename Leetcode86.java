public class Leetcode86 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode res=new ListNode(-1);
        ListNode trs=res;
        ListNode big=new ListNode(-1);
        ListNode tbg=big;
        while (head!=null){
            ListNode tmp=head.next;
            head.next=null;
            if (head.val<x){
                trs.next=head;
                trs=trs.next;
            }else{
                tbg.next=head;
                tbg=tbg.next;
            }
            head=tmp;
        }
        trs.next=big.next;
        return res.next;
    }
}
