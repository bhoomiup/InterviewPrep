package graph.hard;

import java.util.*;

class Pair3{
    int node;
    int cost;
    Pair3(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
public class GraphWithShortestPathCalc {
    List<List<Pair3>> adj;
    int noOfNodes = 0;
    public GraphWithShortestPathCalc(int n, int[][] edges) {
        noOfNodes = n;
        adj = new ArrayList<>();
        for(int i=0;i<n; i++) adj.add(new ArrayList<>());
        for (int[] e: edges)adj.get(e[0]).add(new Pair3(e[1], e[2]));
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair3(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = new int[noOfNodes];
        Arrays.fill(dist, (int)1e9);
        PriorityQueue<Pair3> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.cost));
        pq.add(new Pair3(node1, 0));
        while (!pq.isEmpty()){
            Pair3 curr = pq.poll();
            int currNode = curr.node;
            int currCost = curr.cost;
            for(Pair3 p: adj.get(currNode)){
                int adjNode = p.node;
                int adjCost = p.cost;
                if(currCost+adjCost<dist[adjNode]){
                    dist[adjNode] = currCost+adjCost;
                    pq.add(new Pair3(adjNode, dist[adjNode]));
                }
            }
        }
        return dist[node2]==(int)1e9?-1: dist[node2];
    }
}
