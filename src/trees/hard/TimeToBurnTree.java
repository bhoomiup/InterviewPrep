package trees.hard;

import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class TimeToBurnTree {
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
        ArrayList<BinaryTreeNode<Integer>> startNodeArr = new ArrayList<>();
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        parentMap(root, parentMap, startNodeArr, start);
        BinaryTreeNode<Integer> startNode = startNodeArr.get(0);
        return findTime(startNode, parentMap);
    }

    public static int findTime(BinaryTreeNode<Integer> startNode,
                               HashMap<BinaryTreeNode<Integer>,
                                       BinaryTreeNode<Integer>> parentMap){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        HashSet<BinaryTreeNode<Integer>> visited = new HashSet<>();
        int time = 0;
        q.add(startNode);
        while (!q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                BinaryTreeNode<Integer> temp = q.poll();
                if(temp.left!=null && !visited.contains(temp.left)) {
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)) {
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                BinaryTreeNode<Integer> parent = parentMap.get(temp);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            time++;
        }
        return time;
    }

    public static void parentMap(BinaryTreeNode<Integer> root, HashMap<BinaryTreeNode<Integer>,
            BinaryTreeNode<Integer>> parentMap, ArrayList<BinaryTreeNode<Integer>>  op, int start){
        if(root.left==null && root.right==null) return;
        if (root.data==start) op.add(root);
        if (root.left!=null) parentMap.put(root.left, root);
        if (root.right!=null) parentMap.put(root.right, root);
        if (root.left!=null) parentMap(root.left, parentMap, op, start);
        if (root.right!=null) parentMap(root.right, parentMap, op, start);
    }

    public static void main(String[] args) {

    }
}
