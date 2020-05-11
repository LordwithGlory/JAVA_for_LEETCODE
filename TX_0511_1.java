import java.util.HashSet;
import java.util.Set;

public class TX_0511_1 {
    class ListNode{
        int val;
        ListNode next;
    }

    public ListNode findhaad(ListNode head){
        Set<ListNode> hasviewed=new HashSet<>();
        while (head!=null){
            if (hasviewed.contains(head))
                break;
            hasviewed.add(head);
            head=head.next;
        }
        return head;
    }

    public int maxInternal(int[] arr){
        // 本来这个可以使用桶排序的
        int maxspace=1;
        int maxnum=arr[0];
        int minnum=arr[0];
        for (int num:arr){
            maxnum=Math.max(num,maxnum);
            minnum=Math.min(num,minnum);
        }
        boolean[] findit=new boolean[maxnum-minnum+1];
        for (int num:arr)
            findit[num-minnum]=true;
        int beforeone=0;
        for (int pos=1;pos<findit.length;pos++){
            if (findit[pos]){
                maxspace=Math.max(pos-beforeone,maxspace);
                beforeone=pos;
            }
        }
        return maxspace;
    }
}
