package graph.medium;

import java.util.Arrays;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] nodeColor = new int[graph.length];
        Arrays.fill(nodeColor, -1);
        for(int i=0; i<graph.length; i++){
            if(nodeColor[i]==-1){
                if(!DFS(graph, nodeColor, i, 0)) return false;
            }
        }
        return true;
    }

    public boolean DFS(int[][] graph, int[] nodeColor, int currNode, int currColor){
        nodeColor[currNode] = currColor;
        for(int i: graph[currNode]){
            if(nodeColor[i]==-1) {
                if(!DFS(graph, nodeColor, i, 1-currColor)) return false;
            }
            else if (nodeColor[i]==currColor) return false;
        }
        return true;
    }
}
