package binarySearchTree.medium;

import java.util.Stack;

public class RecoverBST {

    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode prev;

    public void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void recoverTree(TreeNode root) {
        helper(root);
        if (last == null) swap(first, middle);
        else swap(first, last);
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) {
            if (root.data < prev.data) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else last = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}