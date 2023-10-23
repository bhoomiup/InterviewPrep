package graph.medium;

import java.util.*;

public class NoOfWaysToReachDest {
    static class Pair{
        int node;
        long time;
        Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        // Prepare adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] i: roads) {
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));
        }
        long[] time = new long[n];
        Arrays.fill(time, (long) 1e18);
        time[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x-> x.time));
        pq.add(new Pair(0, 0));
        int mod = (int) (1e9+7);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currNode = p.node;
            long currTime = p.time;
            for(Pair i: adj.get(currNode)){
                int adjNode = i.node;
                long edTime = i.time;
                long newTime = currTime+edTime;
                if(newTime<time[adjNode]){
                    time[adjNode]=newTime;
                    pq.add(new Pair(adjNode, newTime));
                    ways[adjNode] = ways[currNode];
                } else if (newTime==time[adjNode]) {
                    ways[adjNode] = (ways[currNode]+ways[adjNode])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }

    public static void main(String[] args) {

    }
}
