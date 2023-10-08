package trees.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
};


public class AllRootToLeafPath {
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here.
        List<String> op = new ArrayList<>();
        if(root==null) return op;
        helper(root, new StringBuilder(), op);
        return op;
    }

    static void helper(TreeNode root, StringBuilder temp, List<String> op){
        if(root==null) return;
        int tmp = temp.length();
        if(root.left==null && root.right==null){
            temp.append(root.data);
            op.add(temp.toString());
            temp.delete(tmp , temp.length());
            return;
        }
        temp.append(root.data).append("->");
        helper(root.left, temp, op);
        helper(root.right, temp, op);
        temp.delete(tmp , temp.length());
    }

}
