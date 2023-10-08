package binarySearchTree.medium;
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

public  class InsertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root.left==null && root.right==null){
            if (val<root.data) root.left = new TreeNode(val);
            else root.right = new TreeNode(val);
            return root;
        }
        if(root.left==null && val<root.data ){
             root.left = new TreeNode(val);
             return root;
        }
        if(root.right==null && val>root.data ){
            root.right = new TreeNode(val);
            return root;
        }
        if(val<root.data) insertIntoBST(root.left, val);
        else insertIntoBST(root.right, val);
        return root;
   }
}

