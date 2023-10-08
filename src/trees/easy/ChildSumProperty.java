package trees.easy;
class Node {
    public int data;
    public Node left;
    public Node right;

    Node()
    {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class ChildSumProperty {

    public static boolean isParentSum(Node root) {
        // Write your code here.
        if((root==null) || (root.left==null && root.right ==null)) return true;
        // Write your code here.
        int sum = 0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;
        if(sum!=root.data) return false;
        return isParentSum(root.left) && isParentSum(root.right);
    }
}
