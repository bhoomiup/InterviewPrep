package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(visited[i]!=1){
                BFS(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void BFS(int[][] isConnected, int[] visited, int startNode){
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = 1;
        while (!q.isEmpty()){
            Integer node = q.poll();
            for (int i=0; i<isConnected.length; i++){
                if(i!=node && visited[i]!=1 && isConnected[node][i]==1){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public void DFS(int[][] isConnected, int[] visited, int startNode){
        visited[startNode] = 1;
        for (int i=0; i<isConnected.length; i++){
            if(i!=startNode && visited[i]!=1 && isConnected[startNode][i]==1){
                DFS(isConnected, visited, i);
            }
        }
    }
}
