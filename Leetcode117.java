public class Leetcode117 {
    // 这个程序居然两个地方都是满分了hhh
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left,Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root==null)
            return null;
        if (root.left!=null){
            if (root.right!=null){
                root.left.next=root.right;
            }else {
                Node root_copy=root.next;
                while (root_copy!=null){
                    if (root_copy.left!=null){
                        root.left.next=root_copy.left;
                        break;
                    }else if(root_copy.right!=null){
                        root.left.next=root_copy.right;
                        break;
                    }
                    root_copy=root_copy.next;
                }
            }
        }
        if(root.right!=null) {
            Node root_copy=root.next;
            while (root_copy!=null){
                if (root_copy.left!=null){
                    root.right.next=root_copy.left;
                    break;
                }else if (root_copy.right!=null){
                    root.right.next=root_copy.right;
                    break;
                }
                root_copy=root_copy.next;
            }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
