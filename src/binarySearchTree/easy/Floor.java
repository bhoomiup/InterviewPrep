package binarySearchTree.easy;

public class Floor {
    public static int Floor(TreeNode node, int input) {
        /*Your class should be named Solution.
         *Don't write main().
         *Don't take input, it is passed as function argument.
         *Don't print output.
         *Taking input and printing output is handled automatically.
         */
        // Write your code here
        int[] op = new int[1];
        op[0] = -1;
        helper(node, op, input);
        return op[0];
    }

    static void  helper(TreeNode root, int[] op, int x){
        if (root==null) return ;
        if(root.data==x) {
            op[0] = x;
            return;
        }
        if(root.data<x){
            op[0] = root.data;
            helper(root.right, op, x);
        }else helper(root.left, op, x);
    }
}
