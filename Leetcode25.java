public class Leetcode25 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode swapAll(ListNode head) {
        // 如果俺说的没错我完美的写了一个reverse的代码
        // 没想到这个地方用上了
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2){
            return head;
        }
        ListNode res=new ListNode(0);
        ListNode tmpres=res;
        while (head!=null){
            ListNode tmpln=head;
            // tmpk用来做计数
            int tmpk=k;
            while (tmpk>1){
                head=head.next;
                tmpk--;
                if(head==null){
                    // 开始时候条件里面写了tmpk不为1
                    // 后面发现即使为1现在的head刚刚好是这次的最后一个
                    // 最后一个如果为null则说明少于规定数目
                    tmpres.next=tmpln;
                    return  res.next;
                }
            }
            // 更换到下一个起点
            if(head!=null){
                ListNode tmpn=head.next;
                head.next=null;
                head=tmpn;
            }
            // 说明的确完成一轮遍历
            if(tmpk==1){
                tmpln=swapAll(tmpln);
                tmpres.next=tmpln;
            }
            while (tmpres.next!=null){
                tmpres=tmpres.next;
            }
        }
        return res.next;
    }
}
