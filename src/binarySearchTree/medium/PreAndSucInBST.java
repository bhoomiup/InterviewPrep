package binarySearchTree.medium;

import java.util.ArrayList;

public class PreAndSucInBST {
//    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
//        // Write your code here.
//        ArrayList<Integer> op = new ArrayList<>();
//        op.add(root.data);
//        findPre(root, key, op);
//        op.add(root.data);
//        findSuc(root, key, op);
//        return op;
//    }
//
//    public static void findPre(TreeNode root, int key, ArrayList<Integer> op){
//        if(root==null) return ;
//        findPre(root.left, key, op);
//        if(root.data<key) op.set(0, root.data);
//        else return ;
//        findPre(root.right, key, op);
//    }
//
//    public static void findSuc(TreeNode root, int key, ArrayList<Integer> op){
//        if(root==null) return ;
//        findSuc(root.right, key, op);
//        if(root.data>key) op.set(1, root.data);
//        else return ;
//        findSuc(root.left, key, op);
//    }

    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        ArrayList<Integer> op = new ArrayList<>();
        op.add(-1);
        op.add(-1);
        findPre(root, key, op);
        findSuc(root, key, op);
        return op;
    }

    public static void findPre(TreeNode root, int key, ArrayList<Integer> op){
        if(root==null) return ;
        if(root.data<key) {
            if(op.get(0)!=-1) op.set(0, Integer.max(root.data, op.get(0)));
            else  op.set(0,root.data);
        }
        if(key<root.data) findPre(root.left, key, op);
        else findPre(root.right, key, op);
    }

    public static void findSuc(TreeNode root, int key, ArrayList<Integer> op){
        if(root==null) return ;
        if(root.data>key) {
            if(op.get(1)!=-1) op.set(0, Integer.min(root.data, op.get(1)));
            else  op.set(1,root.data);
        }
        if(key>root.data) findSuc(root.right, key, op);
        else findSuc(root.left, key, op);
    }
}
