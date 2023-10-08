package trees.medium;

import trees.basic.BTPreOrderTraversal;

import java.util.*;

public class RightViewOfBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class Tuple {
        TreeNode treeNode;
        int row;

        Tuple(TreeNode treeNode, int row) {
            this.treeNode = treeNode;
            this.row = row;
        }
    }

    ArrayList<Integer> rightSideView(TreeNode root)
    {
        // 1. Brute force
//        // add your code
//        if (root==null) return new ArrayList<>();
//        Map<Integer, Integer> ds = new HashMap<>();
//        Queue<Tuple> q = new LinkedList<>();
//        q.add(new Tuple(root, 0));
//        while (!q.isEmpty()){
//            int qsize = q.size();
//            for (int i=0; i<qsize; i++){
//                Tuple temp = q.poll();
//                ds.put(temp.row, temp.treeNode.val);
//                if(temp.treeNode.left!=null) q.add(new Tuple(temp.treeNode.left, temp.row+1));
//                if(temp.treeNode.right!=null) q.add(new Tuple(temp.treeNode.right, temp.row+1));
//            }
//        }
//        return new ArrayList<>(ds.values());
        //2. Optimal
        ArrayList<Integer> op = new ArrayList<>();
        helper(root, 0, op);
        return op;
    }

    void helper(TreeNode root, int level, ArrayList<Integer> op){
        if (root==null) return;
        if(level==op.size()) op.add(root.val);
        if (root.right!=null) helper(root.right, level+1, op );
        if (root.left!=null) helper(root.left, level+1, op );
    }
}


