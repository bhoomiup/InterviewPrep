package trees.medium;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode treeNode;
    int index;
    Pair(TreeNode treeNode, int index){
        this.treeNode = treeNode;
        this.index = index;
    }
}
public class MaxWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        int index=0;
        int sub=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, index));
        while (!q.isEmpty()){
            Pair left = q.peek();
            Pair right = null;
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                right = q.poll();
                if(right.treeNode.left!=null) q.add(new Pair(right.treeNode.left, (2*right.index+1)-sub));
                if(right.treeNode.right!=null) q.add(new Pair(right.treeNode.right, (2*right.index+2)-sub));
            }
            maxWidth = Math.max(right.index-left.index+1, maxWidth);
            sub = right.index;
        }
        return maxWidth;
    }
}
