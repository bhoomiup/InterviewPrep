package trees.medium;

class Pair1{
    int sum;
    int noOfNode;
    Pair1(int sum, int noOfNode){
        this.sum = sum;
        this.noOfNode = noOfNode;
    }
}
public class CountNodesEqualToAvgofSubtree {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    public Pair1 postOrder(TreeNode root){
        if(root.left==null && root.right==null) return new Pair1(root.data, 1);
        Pair1 leftOp = postOrder(root.left);
        Pair1 rightOp = postOrder(root.right);
        int currSum = leftOp.sum+rightOp.sum+root.data;
        int currNoOfNodes = leftOp.noOfNode+rightOp.noOfNode+1;
        int avg = currSum/currNoOfNodes;
        if(avg==root.data) count++;
        return new Pair1(currSum, currNoOfNodes);
    }
}
