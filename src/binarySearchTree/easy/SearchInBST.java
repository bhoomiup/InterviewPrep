package binarySearchTree.easy;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}


public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (root.data == val) return root;
        if (val < root.data) return searchBST(root.left, val);
        else  return searchBST(root.right, val);
    }
}
