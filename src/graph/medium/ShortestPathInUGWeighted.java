package graph.medium;

import java.util.*;
import java.util.stream.Collectors;


class Pair3{
    int node;
    int distance;
    Pair3(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

public class ShortestPathInUGWeighted {
    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source){
        // Write your code here.
        //prepare adj list
        List<List<Pair3>> adj = new ArrayList<>();
        for(int i=0; i< vertices; i++) adj.add(new ArrayList<>());
        for(int[] i: edge ){
            adj.get(i[0]).add(new Pair3(i[1], i[2]));
            adj.get(i[1]).add(new Pair3(i[0], i[2]));
        }

        int[] dist = new int[vertices];
        Arrays.fill(dist, (int)(1e9));
        dist[source] = 0;

        // 1. Priority Queue
        PriorityQueue<Pair3> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        pq.add(new Pair3(source, 0 ));
        while (!pq.isEmpty()){
            Pair3 p = pq.poll();
            int node = p.node;
            int currDist = p.distance;
            for(Pair3 i: adj.get(node)){
                if(currDist+i.distance<dist[i.node]){
                    dist[i.node] = currDist+i.distance;
                    pq.add(new Pair3(i.node, dist[i.node]));
                }
            }
        }
        return Arrays.stream(dist).boxed().collect(Collectors.toList());





    }
}
