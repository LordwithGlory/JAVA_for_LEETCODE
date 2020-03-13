public class Leetcode160 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)
            return null;
        int lenone=0;
        int lentwo=0;
        ListNode headA_cp=headA;
        ListNode headB_cp=headB;
        while (headA_cp!=null){
            lenone++;
            headA_cp=headA_cp.next;
        }
        while (headB_cp!=null){
            lentwo++;
            headB_cp=headB_cp.next;
        }
        while (lenone>lentwo){
            headA=headA.next;
            lenone--;
        }
        while (lentwo>lenone){
            headB=headB.next;
            lentwo--;
        }
        while (headA!=headB){
            if (headA==null||headB==null)
                return null;
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
