package trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInOrderTraversal {
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

    List<Integer> op = new ArrayList<>();
//    // Method 1: Recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root==null) return op;
//        inorderTraversal(root.left);
//        op.add(root.val);
//        inorderTraversal(root.right);
//        return op;
//    }

// 2. Iterative
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root==null) return op;
//        Stack<TreeNode> s = new Stack<>();
//        TreeNode node = root;
//        while (true) {
//            if(node!=null){
//                s.add(node);
//                node = node.left;
//            }else {
//                if(s.empty()) break;
//                node = s.pop();
//                op.add(node.val);
//                node = node.right;
//            }
//        }
//        return op;
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left==null){
                op.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                //to mark thread
                while (prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }
                // if thread already marked
                if(prev.right==curr){
                    prev.right = null;
                    op.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return op;
    }
}
