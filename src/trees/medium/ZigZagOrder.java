package trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrder {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> op = new ArrayList<>();
        if (root==null) return op;
        boolean flag = false;
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left!=null) q.offer(curr.left);
                if (curr.right!=null) q.offer(curr.right);
            }
            if (flag) reverse(temp, 0, temp.size()-1);
            flag = !flag;
            op.add(temp);
        }
        return op;
    }

    public static void reverse(List<Integer> arr, int startIndex, int endIndex){
        int i = startIndex;
        int j = endIndex;
        while (i<j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }
}
