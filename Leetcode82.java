public class Leetcode82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        // z最快的那个思路主要是如果遇到一个新的数字就一支往后遍历到这个数字结束
        // 如果新数字下一个和他一样就继续遍历到新数字
        if (head==null)
            return null;
        int former=head.val-1;
        ListNode tmp=new ListNode(former);
        ListNode res=tmp;
        int counter=0;
        while (head!=null){
            if (head.val==former){
                head=head.next;
                continue;
            }
            else if (head.next!=null&&head.next.val==head.val){
                former=head.val;
                head=head.next.next;
                continue;
            }
            tmp.next=head;
            former=head.val;
            tmp=tmp.next;
            head=head.next;
            tmp.next=null;
        }
        return res;
    }
}
