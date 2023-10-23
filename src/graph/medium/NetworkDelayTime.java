package graph.medium;

import java.util.*;

public class NetworkDelayTime {

    static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Prepare adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] i: times) adj.get(i[0]).add(new Pair(i[1], i[2]));

        int[] time = new int[n+1];
        Arrays.fill(time, (int)1e9);
        time[0] = 0;
        time[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.time));
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currTime = curr.time;
            for(Pair p: adj.get(currNode)){
                int adjNode = p.node;
                int edTime = p.time;
                if(currTime+edTime<time[adjNode]){
                    time[adjNode] = currTime+edTime;
                    pq.add(new Pair(adjNode, time[adjNode]));
                }
            }
        }
        for(int i: time) if(i==(int)1e9) return -1;
        return Arrays.stream(time).max().getAsInt();
    }
}
