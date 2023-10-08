package binarySearchTree.medium;

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        addLefts(root);
    }

    public int next() {
        TreeNode next = this.s.pop();
        if (next.right!= null) addLefts(next.right);
        return next.data;
    }

    public boolean hasNext() {
        return !this.s.empty();
    }

    public void addLefts(TreeNode node){
        while (node!=null) {
            this.s.add(node);
            node=node.left;
        }
    }
}