public class Leetcode147 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode res=head;
        if (res==null)
            return null;
        for (;head.next!=null;){
            ListNode movehead=head.next;
            ListNode nexthead=movehead.next;
            if (movehead.val<head.val){
                head.next=nexthead;
                if (movehead.val<res.val){
                    movehead.next=res;
                    res=movehead;
                    continue;
                }
                ListNode head_cp=res;
                while (head_cp.next.val<movehead.val)
                    head_cp=head_cp.next;
                movehead.next=head_cp.next;
                head_cp.next=movehead;
            }else {
                head=movehead;
            }
        }
        return res;
    }
}
