import java.util.List;

public class Leetcode141 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public boolean hasCycle(ListNode head) {
        ListNode quick=head;
        ListNode slow=head;
        while (quick!=null){
            quick=quick.next;
            if (quick==null)
                break;
            quick=quick.next;
            if (quick==slow)
                return true;
            slow=slow.next;
        }
        return false;
    }
}
