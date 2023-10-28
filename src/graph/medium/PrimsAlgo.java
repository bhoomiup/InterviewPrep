package graph.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    static class Tuple{
        int node;
        int dist;
        int parent;
        Tuple(int node, int dist, int parent){
            this.node = node;
            this.dist = dist;
            this.parent = parent;
        }
    }
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        //Your code goes here
        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (ArrayList<Integer> i: edges){
            adj.get(i.get(0)).add(new Pair(i.get(1), i.get(2)));
            adj.get(i.get(1)).add(new Pair(i.get(0), i.get(2)));
        }

        int[] visited = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.dist));
        pq.add(new Pair(0, 0));
        int sum = 0;
//        List<List<Integer>> mst = new ArrayList<>();
        while (!pq.isEmpty()){
            Pair t = pq.poll();
            int currNode = t.node;
            int currDist = t.dist;
            if(visited[currNode]==1) continue;
            visited[currNode] = 1;
            sum+=currDist;
//            // to create mst
//            List<Integer> temp = new ArrayList<>();
//            temp.add(currParent);
//            temp.add(currNode);
//            mst.add(temp);
//            //
            for(Pair p: adj.get(currNode)){
                int adjNode = p.node;
                int adjDist = p.dist;
                if(visited[adjNode]!=1){
                    pq.add(new Pair(adjNode, adjDist));
                }
            }
        }
        return sum;
    }
}
