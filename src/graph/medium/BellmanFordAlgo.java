package graph.medium;

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgo {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        dist[0] = 0;

        for(int i=0; i<n-1; i++){
            for(List<Integer> e: edges){
                int u = e.get(0);
                int v = e.get(1);
                int w = e.get(2);
                if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }

        //2. if there is negative cycle, return
        for(List<Integer> e: edges){
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
