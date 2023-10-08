package trees.easy;

import trees.medium.maxPathSum;

public class IdenticalBT {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);
        return true;
    }
}
