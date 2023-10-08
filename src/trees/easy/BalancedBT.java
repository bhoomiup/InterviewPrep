package trees.easy;

public class BalancedBT {
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
    public  boolean isBalanced(TreeNode root) {
        return maxDepth(root) > -1;
    }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(l==-1 || r== -1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return 1+Math.max(l, r);
    }

    public static void main(String[] args) {
    }
}
