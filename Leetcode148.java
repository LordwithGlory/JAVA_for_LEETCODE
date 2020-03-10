import java.util.*;

public class Leetcode148 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public ListNode sortList(ListNode head) {
        // 较快的用了快慢表进行归并排序，还有这个功能。。。
        // 我的按道理是最快的，如果比较时候写的更好的话。。。
        if (head==null||head.next==null)
            return head;
        ListNode fomer=new ListNode(-1);
        ListNode backr=new ListNode(-1);
        ListNode head_cp=head.next;
        head.next=null;
        while (head_cp!=null){
            if (head_cp.val<head.val){
//                s.next = head;
//                s = s.next;
                ListNode next=fomer.next;
                fomer.next=head_cp;
                head_cp=head_cp.next;
                fomer.next.next=next;
            }else {
                ListNode next=backr.next;
                backr.next=head_cp;
                head_cp=head_cp.next;
                backr.next.next=next;
            }
        }
        fomer=sortList(fomer.next);
        backr=sortList(backr.next);
        head.next=backr;
        ListNode res=fomer;
        if (res==null)
            res=head;
        else {
            while (fomer.next!=null)
                fomer=fomer.next;
            fomer.next=head;
        }
        return res;
    }
}
