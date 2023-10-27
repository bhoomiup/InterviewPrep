package graph.medium;

import java.util.*;

public class CityWithSmallestNoOfNeigh {
// 1.Djikstra Algo
//    static class Pair{
//        int node;
//        int dist;
//        Pair(int node, int dist){
//            this.node = node;
//            this.dist = dist;
//        }
//    }
//    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        List<List<Pair>> adj = new ArrayList<>();
//        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
//        for(int[] i: edges){
//            adj.get(i[0]).add(new Pair(i[1], i[2]));
//            adj.get(i[1]).add(new Pair(i[0], i[2]));
//        }
//
//        int city = 0;
//        int minCitesUnderThres = (int) 1e9;
//        for(int i=0; i<n; i++){
//            int[] dist = new int[n];
//            Arrays.fill(dist, (int)1e9);
//            dist[i]=0;
//
//            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.dist));
//            pq.add(new Pair(i, 0));
//
//            int citesUnderThres = 0;
//            while (!pq.isEmpty()){
//                Pair p = pq.poll();
//                int currNode = p.node;
//                int currDist = p.dist;
//                for(Pair a: adj.get(currNode)){
//                    int adjNode = a.node;
//                    int edWeight = a.dist;
//                    if(currDist+edWeight<dist[adjNode]){
//                        dist[adjNode]= currDist+edWeight;
//                        pq.add(new Pair(adjNode, dist[adjNode]));
//                    }
//                }
//            }
//
//            for(int j=0; j<n; j++) if(dist[j]<distanceThreshold) citesUnderThres++;
//            if(citesUnderThres<=minCitesUnderThres) {
//                city=i;
//                minCitesUnderThres=citesUnderThres;
//            }
//        }
//        return city;
//    }

    // FloydWarshallAlgo

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) dist[i][j]=0;
                else dist[i][j] = (int)1e9;
            }
        }

        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }

        int city = -1;
        int minCount = n;
        for(int i=0; i<n; i++){
            int count = 0;
            for (int j=0; j<n; j++) {
                if(dist[i][j]<distanceThreshold) count++;
            }
            if(count<minCount) {
                minCount=count;
                city=i;
            }
        }
        return city;
    }
}
