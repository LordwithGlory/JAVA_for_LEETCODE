public class Leetcode445 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
    public int addlist(ListNode ln_long,ListNode ln_short,int longlen,int shortlen){
        if (longlen==0&&shortlen==0)
            return 0;
        int addnum=0;
        if (longlen==shortlen){
            addnum=addlist(ln_long.next,ln_short.next,longlen-1,shortlen-1);
            addnum+=ln_short.val;
        }
        else if (longlen>shortlen){
            addnum=addlist(ln_long.next,ln_short,longlen-1,shortlen);
        }
        addnum+=ln_long.val;
        ln_long.val=addnum%10;
        return addnum/10;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1_len=0;
        int l2_len=0;
        ListNode tmptest=l1;
        while (tmptest!=null){
            l1_len++;
            tmptest=tmptest.next;
        }
        tmptest=l2;
        while (tmptest!=null){
            l2_len++;
            tmptest=tmptest.next;
        }
        ListNode long_ln=l1;
        ListNode shot_ln=l2;
        if (l2_len>l1_len){
            long_ln=l2;
            shot_ln=l1;
        }
        int addone=addlist(long_ln,shot_ln,Math.max(l1_len,l2_len),Math.min(l1_len,l2_len));
        if (addone!=0){
            shot_ln=new ListNode(addone);
            shot_ln.next=long_ln;
            return shot_ln;
        }
        return long_ln;
    }
}
