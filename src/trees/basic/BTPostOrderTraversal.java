package trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrderTraversal {
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if(root==null) return op;
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        op.add(root.val);
//        return op;
//    }
    public List<Integer> postorderTraversal(TreeNode root){
        if(root==null) return op;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (!s.empty() || curr!= null){
            if(curr!=null){
                s.add(curr);
                curr = curr.left;
            }else {
                TreeNode temp = s.peek().right;
                if (temp==null){
                    temp = s.pop();
                    op.add(temp.val);
                    while (!s.empty() && temp == s.peek().right){
                        temp = s.pop();
                        op.add(temp.val);
                    }
                }else {
                    curr = temp;
                }
            }
        }
        return op;
    }
}
