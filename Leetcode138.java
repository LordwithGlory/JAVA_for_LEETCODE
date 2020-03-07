import java.util.HashMap;
import java.util.Map;

public class Leetcode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head==null)
            return head;
        Node head_cp=head;
        Node res=null;
        Node res_cpy=res;
        Map<Node,Node> old2new=new HashMap<>();
        while (head_cp!=null){
            if (res==null){
                res=new Node(head_cp.val);
                res_cpy=res;
            }else {
                res.next=new Node(head_cp.val);
                res=res.next;
            }
            old2new.put(head_cp,res);
            head_cp=head_cp.next;
        }
        res=res_cpy;
        while (res_cpy!=null){
            if (head.random!=null&&old2new.containsKey(head.random))
                res_cpy.random=old2new.get(head.random);
            else if (head.random!=null){
                res_cpy.random=new Node(head.random.val);
                old2new.put(head.random,res_cpy.random);
            }
            res_cpy=res_cpy.next;
            head=head.next;
        }
        return res;
    }
}
