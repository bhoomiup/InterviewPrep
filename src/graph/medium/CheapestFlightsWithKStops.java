package graph.medium;

import javax.print.DocFlavor;
import java.util.*;

public class CheapestFlightsWithKStops {

    static class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Prepare adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] i: flights) adj.get(i[0]).add(new Pair(i[1], i[2]));

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0});
        int[] cost = new int[n];
        Arrays.fill(cost, (int) 1e9);
        cost[src] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currStops = curr[0];
            int currNode = curr[1];
            int currCost = curr[2];
            if(currStops>k+1) break;
            for(Pair i: adj.get(currNode)){
                if(currCost+i.cost<cost[i.node]){
                    cost[i.node] = currCost+i.cost;
                    q.add(new int[]{currStops+1, i.node, currCost+i.cost});
                }
            }
        }
        if(cost[dst]==(int)1e9) return -1;
        return cost[dst];
    }
}
