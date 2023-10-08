package binarySearchTree.easy;

import java.util.Stack;

public class TwoSum {
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();


    public TreeNode next() {
        TreeNode next = this.s1.pop();
        if (next.right!= null) addLefts(next.right);
        return next;
    }

    public boolean hasNext() {
        return !this.s1.empty();
    }

    public TreeNode before() {
        TreeNode next = this.s2.pop();
        if (next.left!= null) addRights(next.left);
        return next;
    }

    public boolean hasBefore() {
        return !this.s2.empty();
    }

    public void addLefts(TreeNode node){
        while (node!=null) {
            this.s1.add(node);
            node=node.left;
        }
    }

    public void addRights(TreeNode node){
        while (node!=null) {
            this.s2.add(node);
            node=node.right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root.left==null && root.right==null) return false;
        addLefts(root);
        addRights(root);
        TreeNode left = this.next();
        TreeNode right = this.before();
        while (this.s1!=null && this.s2!=null){
            int sum = left.data+right.data;
            if(sum==k) return true;
            else if (sum<k) left = this.next();
            else right = this.before();
        }
        return false;
    }

}
