package trees.medium;

public class FlattenBTToLL {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left!=null) {
                TreeNode prev = curr.left;
                //to mark right
                while (prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr=curr.right;
        }
    }
}