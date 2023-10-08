package binarySearchTree.easy;

public class MinInBT {
    public static int minValue(TreeNode root) {
        if(root==null) return -1;
        // Write your code here.
        if(root.left==null) return root.data;
        return minValue(root.left);
    }
}
