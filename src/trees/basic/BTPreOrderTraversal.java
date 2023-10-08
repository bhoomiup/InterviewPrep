package trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreOrderTraversal {
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
//    // Method - 1: Recursive

//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root==null) return op;
//        op.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return op;
//    }

//    // Method - 2: Iterative

//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root==null) return op;
//        Stack<TreeNode> s = new Stack<>();
//        s.add(root);
//        while (!s.empty()) {
//            TreeNode t = s.pop();
//            if(t.right != null) s.add(t.right);
//            if(t.left != null) s.add(t.left);
//            op.add(t.val);
//        }
//        return op;
//    }

//    // 3. Morris
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> op = new ArrayList<>();
//        TreeNode curr = root;
//        while (curr!=null){
//            if(curr.left==null){
//                op.add(curr.val);
//                curr = curr.right;
//            }
//            else {
//                TreeNode prev = curr.left;
//                //to mark thread
//                while (prev.right!=null && prev.right!=curr){
//                    prev = prev.right;
//                }
//                if(prev.right==null){
//                    prev.right = curr;
//                    op.add(curr.val);
//                    curr = curr.left;
//                }
//                // if thread already marked
//                if(prev.right==curr){
//                    prev.right = null;
//                    curr = curr.right;
//                }
//            }
//        }
//        return op;
//    }
}

