
public class Leetcode19 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        // 真特娘的憨批题目 就是简单的链表而已，还给我标记一中等难度
        int nowpops=0;
        int len=0;
        ListNode tmphead=head;
        while (tmphead!=null){
            len++;
            tmphead=tmphead.next;
        }
        tmphead=head;
        n=len-n;
        if (n==0){
            return head.next;
        }
        while (nowpops<n-1){
            tmphead=tmphead.next;
            nowpops++;
        }
        tmphead.next=tmphead.next.next;
        return head;
    }
}
