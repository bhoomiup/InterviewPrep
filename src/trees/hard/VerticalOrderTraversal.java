package trees.hard;

import java.util.*;

public class VerticalOrderTraversal {

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

    public class Tuple {
        TreeNode treeNode;
        int row;
        int col;

        Tuple(TreeNode treeNode, int row, int col) {
            this.treeNode = treeNode;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> ds = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        List<List<Integer>> op = new ArrayList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Tuple temp = q.poll();
                if (!ds.containsKey(temp.col)) ds.put(temp.col,  new TreeMap<>());
                if (!ds.get(temp.col).containsKey(temp.row)) ds.get(temp.col).put(temp.row, new PriorityQueue<>());

                ds.get(temp.col).get(temp.row).add(temp.treeNode.data);
                if (temp.treeNode.left != null) q.add(new Tuple(temp.treeNode.left, temp.row + 1, temp.col - 1));
                if (temp.treeNode.right != null) q.add(new Tuple(temp.treeNode.right, temp.row + 1, temp.col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> t : ds.values()) {
            op.add(new ArrayList<>());
            for (PriorityQueue<Integer> p : t.values()) {
                while (!p.isEmpty()) op.get(op.size() - 1).add(p.poll());
            }
        }
        return op;

    }

}
