package graph.medium;

import java.util.ArrayList;
import java.util.Map;

public class FloydWarshallAlgo {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[][] dist = new int[n+1][n+1];
        for (int i=0; i<=n+1; i++){
            for(int j=0; j<=n+1; j++){
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = (int) 1e9;
            }
        }

        for(ArrayList<Integer> e: edges){
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            dist[u][v] = w;
        }

        for(int via=1; via<=n; via++){
            for(int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }

        // To detect if there is negative cycle
        for (int i=1; i<=n; i++) if (dist[i][i]<0) return -1;

        return dist[src][dest];
    }
}
