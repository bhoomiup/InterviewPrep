package binarySearchTree.medium;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long l, long h){
        if (root==null) return true;
        if(root.data<=l || root.data>=h) return false;
        return helper(root.left, l, root.data) &&  helper(root.right, root.data, h);

    }
}
