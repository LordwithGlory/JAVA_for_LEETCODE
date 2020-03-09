import java.util.ArrayList;
import java.util.List;

public class Leetcode143 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public void reorderList(ListNode head) {
        List<ListNode> nodelist=new ArrayList<>();
        ListNode res=head;
        while (head!=null){
            nodelist.add(head);
            head=head.next;
        }
        head=res;
        if (nodelist.size()<3)
            return;
        for (int pos=nodelist.size()-1;head!=null&&head.next!=null;pos--){
            nodelist.get(pos-1).next=null;
            nodelist.get(pos).next=head.next;
            head.next=nodelist.get(pos);
            head=head.next.next;
        }
        head=res;
    }
}
