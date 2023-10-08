package trees.medium;

import java.util.HashMap;

public class ConstructBTFromInOrderPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++)  map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode helper(int[] preorder, int pStart, int pEnd ,int[] inorder, int iStart, int iEnd,
                       HashMap<Integer, Integer> map){
        if((pStart>pEnd) || (iStart>iEnd)) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int inRoot = map.get(preorder[pStart]);
        int numLeft = inRoot-iStart;
        root.left = helper(preorder, pStart+1, pStart+numLeft, inorder, iStart, inRoot-1, map);
        root.right = helper(preorder, pStart+numLeft+1, pEnd, inorder, inRoot+1, iEnd, map);
        return root;
    }
}
