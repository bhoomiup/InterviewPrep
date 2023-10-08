package trees.medium;


import trees.easy.DiameterOfBT;

public class maxPathSum {
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

    public int maxPathSum(TreeNode root) {
        if (root==null) return 0;
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxDepth(root, maxi);
        return Math.max(maxi[0], 0);
    }

    public int maxDepth(TreeNode root, int[] maxi) {
        if (root==null) return 0;
        int l = maxDepth(root.left, maxi);
        int r = maxDepth(root.right, maxi);
        maxi[0] = Math.max(maxi[0], (root.val+l+r));
        return root.val+Math.max(l, r);
    }
}
