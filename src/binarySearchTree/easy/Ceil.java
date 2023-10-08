package binarySearchTree.easy;

public class Ceil {
    public  static int findCeil(TreeNode node, int x) {

        // Write your code here
        int[] op = new int[1];
        op[0] = -1;
        helper(node, op, x);
        return op[0];
    }

    static void  helper(TreeNode root, int[] op, int x){
        if (root==null) return ;
        if(root.data==x) {
            op[0] = x;
            return;
        }
        if(root.data>x){
            op[0] = root.data;
            helper(root.left, op, x);
        }else helper(root.right, op, x);
    }
}
