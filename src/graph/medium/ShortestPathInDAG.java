package graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Pair1{
    int node;
    int weight;
    Pair1(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathInDAG {
    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        List<List<Pair1>> adj = new ArrayList<>();
        for(int i=0; i<n;i++) adj.add(new ArrayList<>());
        for(int[] i: edges){
            adj.get(i[0]).add(new Pair1(i[1], i[2]));
        }

        // perform topo sort
        Stack<Integer> s = new Stack<>();
        int[] visited = new int[n];
        for(int i=0; i<n; i++){
            if(visited[i]!=1) DFS(adj, visited, i, s);
        }

        //find the shortest path
        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[0] = 0;

        while (!s.isEmpty()){
            int node = s.pop();

            for(Pair1 p: adj.get(node)){
                int nod = p.node;
                int weight = p.weight;
                if(dist[node]+weight<dist[nod]){
                    dist[nod] = dist[node]+weight;
                }
            }
        }
        for(int i=0;i<n;i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;

        return dist;
    }

    public static void  DFS(List<List<Pair1>> adj,int[] visited,int i,Stack<Integer> s){
        visited[i] = 1;
        for(Pair1 p: adj.get(i)){
            if(visited[p.node]!=1) DFS(adj, visited, p.node, s );
        }
        s.add(i);
    }

    public static void main(String[] args) {
        shortestPathInDAG(3, 3, new int[][]{{0, 1, 2},  {1, 2, 3}, {0, 2, 6}});
    }
}