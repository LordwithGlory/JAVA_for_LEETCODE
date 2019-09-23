public class Leetcode24 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode swapAll(ListNode head) {
        // 如果俺说的没错我完美的写了一个reverse的代码
        ListNode tmphead=null;
        while (head!=null){
            ListNode nowhead=new ListNode(head.val);
            nowhead.next=tmphead;
            tmphead=nowhead;
            head=head.next;
        }
        head=tmphead;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode tmphead=head;
        while (head!=null){
            int tmp=head.val;
            if(head.next==null){
                break;
            }
            head.val=head.next.val;
            head.next.val=tmp;
            head=head.next.next;
        }
        return tmphead;
    }
}
