package graph.medium;

import java.util.*;
import java.util.stream.Collectors;

class Pair4{
    int node;
    int distance;
    Pair4(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

public class PrintShortestPath {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        //prepare adj list
        List<List<Pair4>> adj = new ArrayList<>();
        for(int i=0; i<= n; i++) adj.add(new ArrayList<>());
        for(int[] i: edges ){
            adj.get(i[0]).add(new Pair4(i[1], i[2]));
            adj.get(i[1]).add(new Pair4(i[0], i[2]));
        }

        PriorityQueue<Pair4> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.add(new Pair4(1, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)(1e9));
        dist[1] = 0;
        int[] parent = new int[n+1];
        while (!pq.isEmpty()){
            Pair4 p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            for(Pair4 i: adj.get(node)){
                int adjNode = i.node;
                int adjDist = i.distance;
                if(distance+adjDist<dist[adjNode]){
                    dist[adjNode] = distance+adjDist;
                    pq.add(new Pair4(adjNode, dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        if(dist[n]==(int)(1e9)) {
            shortestPath.add(-1);
            return shortestPath;
        }

        int node = n;
        while (parent[node]!=node){
            shortestPath.add(node);
            node = parent[node];
        }
        shortestPath.add(1);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
