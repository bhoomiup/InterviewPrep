package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {

//    //1. DFS
//    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
//        // Write your code here!
//        // prepare adj list
//        List<List<Integer>> adj = new ArrayList<>();
//
//        for(int i=0; i<v; i++) adj.add(new ArrayList<>());
//
//        for(int[] i: edges) adj.get(i[0]).add(i[1]);
//
//        List<Integer> op = new ArrayList<>();
//        boolean[] visited = new boolean[v];
//        for(int i = 0; i<v; i++){
//            if(!visited[i]) DFS(adj, visited, op, i);
//        }
//        int start = 0;
//        int end = op.size()-1;
//        while (start<end){
//            int temp = op.get(start);
//            op.set(start, op.get(end));
//            op.set(end, temp);
//            start++;
//            end--;
//        }
//        return op;
//    }
//
//    public static void DFS(List<List<Integer>> adj,boolean[] visited,List<Integer> op,int startNode){
//        visited[startNode] = true;
//        for(int i: adj.get(startNode)){
//            if(!visited[i]) DFS(adj, visited, op, i );
//        }
//        op.add(startNode);
//    }

    // 2. BFS/ kahn's Algorithm

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<Integer> op = new ArrayList<>();

        // prepare adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) adj.add(new ArrayList<>());
        for(int[] i: edges) adj.get(i[0]).add(i[1]);

        // prepare in degree
        int[] inDegrees = new int[v];
        for(int i=0; i<v; i++){
            for(int j: adj.get(i)){
                inDegrees[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length; i++ )if (inDegrees[i]==0) q.add(i);

        while (!q.isEmpty()){
            int temp = q.poll();
            op.add(temp);
            for(int i: adj.get(temp)) {
                inDegrees[i]--;
                if(inDegrees[i]==0) q.add(i);
            }
        }

        return op;
    }
}
