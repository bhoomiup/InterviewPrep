package graph.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int node;
    int parent;
    Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
public class DetectCycleInUnDirectedGraph {

//
//    // 1. BFS
//      boolean detectCycle(int V, List<List<Integer>> adj) {
//    // Write your code here.
//    int[] visited = new int[V+1];
//    for(int i=0; i<V; i++){
//        if(visited[i]!=1 && BFS(adj, visited, i)) return true;
//    }
//    return false;
//}
//
//    boolean BFS(List<List<Integer>> adj, int[] visited, int startNode){
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(startNode, -1));
//        visited[startNode] = 1;
//        while (!q.isEmpty()){
//            Pair node = q.poll();
//            for(int i:adj.get(node.node)){
//                if(visited[i]!=1){
//                    q.add(new Pair(i, node.node));
//                    visited[i] = 1;
//                }else if(node.parent!=node.node) return true;
//            }
//        }
//        return false;
//    }

    // DFS
    boolean detectCycle(int V, List<List<Integer>> adj) {
        // Write your code here.
        int[] visited = new int[V+1];
        for(int i=0; i<V; i++){
            if(visited[i]!=1 && DFS(adj, visited, new Pair(i, -1))) return true;
        }
        return false;
    }

    // DFS
    boolean DFS(List<List<Integer>> adj, int[] visited, Pair startNode){
        visited[startNode.node] = 1;
        for(int i: adj.get(startNode.node)){
            if (visited[i]==0){
                if(DFS(adj, visited, new Pair(i, startNode.node))) return true;
            }
            else if (i!=startNode.parent) return true;
        }
        return false;
    }
}
