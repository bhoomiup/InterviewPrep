package trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Pair {
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    List<Integer> preop = new ArrayList<>();
    List<Integer> inop = new ArrayList<>();
    List<Integer> postop = new ArrayList<>();

    public void Traversal(TreeNode root) {
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(root, 1));
        while (!s.empty()){
            if(s.peek().pos == 1){
                Pair temp = s.pop();
                preop.add(temp.node.val);
                temp.pos++;
                s.add(temp);
                if (temp.node.left!= null) s.add(new Pair(temp.node.left, 1));
            }
            else if(s.peek().pos == 2){
                Pair temp = s.pop();
                inop.add(temp.node.val);
                temp.pos++;
                s.add(temp);
                if (temp.node.right!= null) s.add(new Pair(temp.node.right, 1));
            }
            else {
                Pair temp = s.pop();
                postop.add(temp.node.val);
            }
        }
    }

}
