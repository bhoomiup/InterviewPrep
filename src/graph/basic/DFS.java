package graph.basic;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> op = new ArrayList<>();
        int[] visited = new int[V];
        helper(adj, visited, op, 0);
        return op;

    }

    public void helper(ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> op, int node){
        op.add(node);
        visited[node] = 1;
        for(int adjNodes: adj.get(node)){
            if(visited[adjNodes]!=1){
                helper(adj, visited, op, adjNodes);
            }
        }
    }
}
