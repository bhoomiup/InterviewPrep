package binarySearchTree.medium;

public class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. Naive
//        if(root==null) return null;
//        if(root==p) return p;
//        if(root==q) return q;
//        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
//        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
//        if(left==null) return right;
//        else if(right==null) return left;
//        else return root;
        if (root==null) return root;
        if (root.data< p.data && root.data<q.data) return lowestCommonAncestor(root.right, p, q);
        else if (root.data> p.data && root.data>q.data) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}
