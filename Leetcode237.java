public class Leetcode237 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
    public void deleteNode(ListNode node) {
        // 刚开始居然没想明白应该咋办
        if (node.next==null){
            // 其实题上不用考虑尾巴
            node=null;
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
