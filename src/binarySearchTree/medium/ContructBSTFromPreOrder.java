package binarySearchTree.medium;

public class ContructBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    public TreeNode helper (int[] preorder, int[] index, int upperBound){
        if(index[0]==preorder.length || preorder[index[0]]>upperBound) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = helper (preorder, index, root.data);
        root.right = helper (preorder, index, upperBound);
        return root;
    }

}
