package trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBT {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public class Tuple {
        Node node;
        int col;

        Tuple(Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    ArrayList<Integer> bottomView(Node root)
    {
        // add your code
        if (root==null) return new ArrayList<>();
        TreeMap<Integer, Integer> ds = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while (!q.isEmpty()){
            int qsize = q.size();
            for (int i=0; i<qsize; i++){
                Tuple temp = q.poll();
                ds.put(temp.col, temp.node.data);
                if(temp.node.left!=null) q.add(new Tuple(temp.node.left, temp.col-1));
                if(temp.node.right!=null) q.add(new Tuple(temp.node.right, temp.col+1));
            }
        }
        return new ArrayList<>(ds.values());
    }
}
