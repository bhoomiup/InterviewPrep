package trees.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static class TreeNode {
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

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> op = new ArrayList<>();
//        if (root == null) return op;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            List<Integer> temp = new ArrayList<>();
//            int qsize = q.size();
//            for(int i=0; i<qsize; i++){
//                TreeNode t = q.poll();
//                if(t.left!=null) q.add(t.left);
//                if(t.right!=null) q.add(t.right);
//                temp.add(t.val);
//            }
//            op.add(temp);
//        }
//        return op;
//    }

    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>>opList=new ArrayList<>();
        pre(root,0,opList);
        return opList;
    }
    public static void pre(TreeNode root,int l,List<List<Integer>>opList)
    {
        if(root==null)
            return;
        if(opList.size()==l)
        {
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            opList.add(li);
        }
        else
            opList.get(l).add(root.val);
        pre(root.left,l+1,opList);
        pre(root.right,l+1,opList);
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        System.out.println(levelOrder(t));
    }

}
