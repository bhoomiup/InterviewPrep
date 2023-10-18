package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

//    //1.  DFS
//    public static boolean detectCycleInDirectedGraph(int n, ArrayList <ArrayList< Integer >> edges) {
//        // Write your code here.
//        // prepare adj list
//        List<List<Integer>> adj = new ArrayList<>();
//        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
//        for(ArrayList<Integer> i: edges) adj.get(i.get(0)).add(i.get(1));
//
//        int[] visited = new int[n];
//        int[] pathVisited = new int[n];
//
//        for(int i=0; i<n; i++){
//            if(visited[i]!=1){
//                if(DFS(adj, visited, pathVisited, i)) return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean DFS(List<List<Integer>> adj, int[] visited, int[] pathVisited, int currNode){
//        visited[currNode] = 1;
//        pathVisited[currNode] = 1;
//        for(int i: adj.get(currNode)){
//            if(visited[i]!=1) {
//                if(DFS(adj, visited, pathVisited, i)) return true;
//            }
//            else if(pathVisited[i]==1) return true;
//        }
//        pathVisited[currNode]= 0;
//        return false;
//    }

    // 2. BFS
    public static boolean detectCycleInDirectedGraph(int n, ArrayList <ArrayList< Integer >> edges) {
        // Write your code here.
        // prepare adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> i: edges) adj.get(i.get(0)).add(i.get(1));

       // prepare inDegree
        int[] inDegrees = new int[n];
        for(int i=0; i<n; i++){
            for(int j: adj.get(i)){
                inDegrees[i]++;
            }
        }

        List<Integer> op = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length; i++ )if (inDegrees[i]==0) q.add(i);
        while (!q.isEmpty()){
            int temp = q.poll();
            op.add(temp);
            for (int i: adj.get(temp)){
                inDegrees[i]--;
                if(inDegrees[i]==0) q.add(i);
            }
        }
        return op.size()==n;
    }

}
