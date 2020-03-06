import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Node,Node> old2new=new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {
        // 最快的那个除了使用dfs之外么的区别啊
        if (node==null)
            return null;
        if (old2new.containsKey(node))
            return old2new.get(node);
        Node node_cp=new Node(node.val,new ArrayList<>());
        old2new.put(node,node_cp);
        for (Node son:node.neighbors){
            node_cp.neighbors.add(cloneGraph(son));
        }
        return node_cp;
    }
}
