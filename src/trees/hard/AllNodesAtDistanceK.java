package trees.hard;

import java.util.*;

public class AllNodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> op = new ArrayList<>();
        if (root==null) return op;
        if (k==0) {
            op.add(target.val);
            return op;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        prepareParentMap(root, parentMap);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> visited = new HashSet<>();
        while (!q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode temp = q.poll();
                if(temp.left!=null && !visited.contains(temp.left)) {
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                TreeNode parent = parentMap.get(temp);
                if(parent!=null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
            k-=1;
            if (k==0) break;
        }
        while (!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=target) op.add(temp.val);
        }
        return op;
    }

    public void prepareParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        if (root==null) return;
        if (root.left !=null){
            parentMap.put(root.left, root);
            prepareParentMap(root.left, parentMap);
        }
        if (root.right !=null){
            parentMap.put(root.right, root);
            prepareParentMap(root.right, parentMap);
        }
    }
}
