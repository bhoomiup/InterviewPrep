package trees.medium;

import java.util.HashMap;

public class ConstructBTFromInOrderPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++)  map.put(inorder[i], i);
        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode helper(int[] postorder, int pStart, int pEnd ,int[] inorder, int iStart, int iEnd,
                           HashMap<Integer, Integer> map) {
        if((pStart>pEnd) || (iStart>iEnd)) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int inORoot = map.get(root.data);
        int numLeft = inORoot-iStart;
        root.left = helper(postorder, pStart, pStart-1+numLeft, inorder, iStart, inORoot-1, map);
        root.right = helper(postorder, pStart+numLeft, pEnd-1, inorder, inORoot+1, iEnd, map);
        return root;

    }
}
