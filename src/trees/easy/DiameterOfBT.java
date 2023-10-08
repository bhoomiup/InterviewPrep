package trees.easy;

import trees.basic.TreeNode;

public class DiameterOfBT {
    //Definition for a binary tree node.
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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        int[] maxi = new int[1];
        maxDepth(root, maxi);
        return maxi[0];
    }

    public int maxDepth(TreeNode root, int[] maxi) {
        if (root==null) return 0;
        int l = maxDepth(root.left, maxi);
        int r = maxDepth(root.right, maxi);
        maxi[0] = Math.max(maxi[0], (1+l+r));
        return 1+Math.max(l, r);
    }

}
