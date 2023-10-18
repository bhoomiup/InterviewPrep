package graph.medium;

import java.util.*;

public class EventualSafeStates {

//    // 1. DFS
//    public static List<Integer> eventualSafeNodes(int[][] graph) {
//        int[] visited = new int[graph.length];
//        int[] pathVisited = new int[graph.length];
//        for (int i=0; i<graph.length; i++){
//            if(visited[i]!=1) DFS(graph, visited, pathVisited, i);
//        }
//        List<Integer> op = new ArrayList<>();
//        for(int i=0; i<pathVisited.length; i++) if(pathVisited[i]==0) op.add(i);
//        return op;
//    }
//
//    public static boolean DFS(int[][] graph, int[] visited,int[] pathVisited, int currNode){
//        visited[currNode] =1;
//        pathVisited[currNode]=1;
//        for(int i: graph[currNode]){
//            if(visited[i]!=1){
//                if(DFS(graph, visited, pathVisited, i)) return true;
//            }
//            else if (pathVisited[i]==1) return true;
//        }
//        pathVisited[currNode] = 0;
//        return false;
//    }

    // 2. BFS
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegrees = new int[graph.length];

        for(int i=0; i<graph.length; i++)  adj.add(new ArrayList<>());
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
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
        op.sort(Comparator.comparingInt(a -> a));
        return op;
    }

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
}
