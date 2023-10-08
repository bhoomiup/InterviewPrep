package trees.medium;

public class NodesInCompleteBT {

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l = leftHeight(root);
        int r = rightHeight(root);
        if(l==r) return (int) Math.pow(2, l)-1;
        else return countNodes(root.left) + countNodes(root.right) + 1;    }

    public int leftHeight(TreeNode node){
        if (node==null) return 0;
        return 1+leftHeight(node.left);
    }

    public int rightHeight(TreeNode node){
        if (node==null) return  0;
        return 1+rightHeight(node.right);
    }
}
