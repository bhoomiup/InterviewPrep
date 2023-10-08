package binarySearchTree.medium;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left==null){
                count++;
                if(count==k) return curr.data;
                curr = curr.right;
            }else {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr) prev = prev.right;
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }
                if(prev.right==curr){
                    prev.right = null;
                    count++;
                    if (count==k) return curr.data;
                    curr = curr.right;
                }
            }
        }
        return curr.data;
    }
}


