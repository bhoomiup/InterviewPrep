package trees.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        if (root == null) return op;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode t = q.poll();
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
                temp.add(t.val);
            }
            op.add(temp);
        }
        return op;
    }

}
