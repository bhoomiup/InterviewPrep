package binarySearchTree.medium;

public class DeleteInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.data==key) return helper(root);
        TreeNode op = root;
        while (root!=null){
            if(root.data>key){
                if (root.left!=null && root.left.data==key){
                    root.left = helper(root.left);
                    break;
                }else root =root.left;
            }else {
                if (root.right!=null && root.right.data==key){
                    root.right = helper(root.right);
                    break;
                }else root=root.right;
            }
        }
        return op;
    }

    public TreeNode helper(TreeNode root){
        if (root.left==null) return root.right;
        if (root.right==null) return root.left;
        TreeNode lastRight = lastRight(root.left);
        lastRight.right = root.right;
        return root.left;
    }

    public TreeNode lastRight(TreeNode node){
        if (node.right==null) return node;
        return lastRight(node.right);
    }

}
