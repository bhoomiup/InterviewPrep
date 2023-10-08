package trees.hard;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryOrderTraversal {

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void leftBoundary(TreeNode root, ArrayList<Integer> op){
        // Write your code here.
        if(root.left==null && root.right==null) return ;
        op.add(root.data);
        if(root.left!=null) leftBoundary(root.left, op);
        else leftBoundary(root.right, op);
    }

    public static void leafBoundary(TreeNode root, ArrayList<Integer> op){
        // Write your code here.
        if(root==null) return ;
        if(root.left==null && root.right==null) op.add(root.data);
        if(root.left!=null) leafBoundary(root.left, op);
        if(root.right!=null) leafBoundary(root.right, op);
    }

    public static void rightBoundary(TreeNode root, Stack<Integer> rightBoundaryStack){
        // Write your code here.
        if(root.left==null && root.right==null) return ;
        rightBoundaryStack.add(root.data);
        if(root.right!=null) rightBoundary(root.right, rightBoundaryStack);
        else rightBoundary(root.left, rightBoundaryStack);
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> op = new ArrayList<>();
        op.add(root.data);
        if(root.left!=null) leftBoundary(root.left, op);
        if(root.left!=null && root.right!=null) leafBoundary(root, op);
        Stack<Integer> rightStack = new Stack<>();
        if(root.right!=null) rightBoundary(root.right, rightStack);
        while (!rightStack.empty()){
            op.add(rightStack.pop());
        }
        return op;
    }
}
