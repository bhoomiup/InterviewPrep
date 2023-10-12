package graph.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] visited = new int[n];
        visited[0] = 1;
        List<Integer> op = new ArrayList<>();
        while(!q.isEmpty())
        {
            Integer node = q.poll();
            op.add(node);
            for(int i: adj.get(node)){
                if(visited[i]!=1){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
        return op;
    }
}
