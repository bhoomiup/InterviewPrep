package trees.medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class rightPointers {
    public Node connect(Node root) {
//        1. Brute force
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            int qs = q.size();
//            Node prev = null;
//            for(int i=0; i<qs; i++){
//                Node temp = q.poll();
//                if (prev!=null) temp.next = temp;
//                prev = temp;
//                if(temp.left!=null) q.add(temp.left);
//                if(temp.right!=null) q.add(temp.right);
//            }
//        }
//        return root;

        // 2. Optimized

        if (root==null) return null;
        if(root.left!=null) root.left.next = root.right;
        if(root.right!=null && root.next!=null) root.right.next= root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
