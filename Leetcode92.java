import java.util.List;

public class Leetcode92 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n)
            return head;
        ListNode res=new ListNode(-1);
        res.next=head;
        head=res;
        for (int i=1;i<m&&head!=null;i++){
            head=head.next;
        }
        // 防止mn越界
        if (head==null||head.next==null)
            return res.next;
        // 标志了最新的数组第一段的末尾
        ListNode reshead=head;
        // 标志第二段的开头
        ListNode restail=null;
        // 最后一段的末尾
        ListNode realtail=null;
        head=head.next;
        while (m<=n&&head!=null){
            ListNode tmp=new ListNode(head.val);
            tmp.next=restail;
            if (restail==null)
                realtail=tmp;
            restail=tmp;
            head=head.next;
            m++;
        }
        realtail.next=head;
        reshead.next=restail;
        return res.next;
    }
}
