package binarySearchTree.medium;
class Val{
    int count;
    int min;
    int max;
    Val(int count, int min, int max){
        this.count =count;
        this.min = min;
        this.max = max;
    }
}
public class LargestBST {

    public static int largestBST(TreeNode root) {
        // Write your code here.
        return helper(root).count;

    }

    public static Val helper(TreeNode root){
        if (root==null) return new Val(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Val valLeft = helper(root.left);
        Val valRight = helper(root.right);
        if(root.data>valLeft.max && root.data<valRight.min) return new Val(valLeft.count + valRight.count + 1,
                Math.min(root.data, valLeft.min), Math.max(root.data, valRight.max));
        else return new Val(Math.max(valLeft.count, valRight.count), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
