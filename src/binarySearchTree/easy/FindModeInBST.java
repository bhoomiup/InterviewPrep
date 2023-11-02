package binarySearchTree.easy;
// Definition for a binary tree node.


import java.util.ArrayList;
import java.util.List;

public class FindModeInBST {
    public int prevNodeVal;
    public int[] findMode(TreeNode root) {
        // curr count and max count
        int[] count = new int[]{0, 0};
        List<Integer> op = new ArrayList<>();
        inOrder(root, count, op);
        return op.stream().mapToInt(i->i).toArray();
    }

    public void inOrder(TreeNode currNode, int[] count, List<Integer> op){
        if(currNode == null) return;
        inOrder(currNode.left, count, op);
        if(currNode.data==prevNodeVal) count[0]=count[0]+1;
        else count[0]=1;
        if(count[0]>count[1]){
            count[1] = count[0];
            op.clear();
            op.add(currNode.data);
        }else if(count[0]==count[1]){
            op.add(currNode.data);
        }
        prevNodeVal = currNode.data;
        inOrder(currNode.right, count, op);
    }
}
