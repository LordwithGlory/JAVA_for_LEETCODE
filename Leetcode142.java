import java.util.ArrayList;
import java.util.List;

public class Leetcode142 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    public ListNode detectCycle(ListNode head) {
//        List<ListNode> mylist=new ArrayList<>();
//        while (head!=null){
//            if (mylist.contains(head))
//                return head;
//            mylist.add(head);
//            head=head.next;
//        }
//        return null;
        // 根据数学证明可以发现某个的确是正确的
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            fast=fast.next;
            if (fast==null)
                break;
            fast=fast.next;
            slow=slow.next;
            if (fast==slow){
                ListNode find=head;
                while (find!=slow){
                    find=find.next;
                    slow=slow.next;
                }
                return find;
            }
        }
        return null;
    }
}
