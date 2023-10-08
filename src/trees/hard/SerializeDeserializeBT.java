package trees.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder op = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()){
            int qsize = q.size();
            for(int i=0 ; i<qsize; i++){
                if (q.peek()!=null) {
                    TreeNode temp = q.poll();
                    q.add(temp.left);
                    q.add(temp.right);
                    op.append(" ").append(temp.val);
                }
                else {
                    q.poll();
                    op.append(" ").append("null");
                }
            }
        }
        return op.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) return null;
        if (Objects.equals(data, "null")) return null;
        String[] ip = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        q.add(root);
        i++;
        while(i<ip.length&&!q.isEmpty()){
            TreeNode temp = q.poll();
            if(!Objects.equals(ip[i], "null")) {
                TreeNode tempLeft = new TreeNode(Integer.parseInt(ip[i]));
                temp.left = tempLeft;
                q.add(tempLeft);

            }
            i++;
            if(!Objects.equals(ip[i], "null")){
                TreeNode tempRight = null;
                tempRight = new TreeNode(Integer.parseInt(ip[i]));
                temp.right = tempRight;
                q.add(tempRight);

            }
            i++;
        }
        return root;
    }
}

