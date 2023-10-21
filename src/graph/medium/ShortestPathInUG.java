package graph.medium;

import java.util.*;

public class ShortestPathInUG {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++) adj.add(new ArrayList<>());
        for(int[] i: edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);

        }

        int[] op = new int[n];
        Arrays.fill(op, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        op[src] = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(int i: adj.get(node)){
                if(op[node] + 1 < op[i]) {
                    op[i] = 1 + op[node];
                    q.add(i);
                }
            }
        }
        for(int i=0;i<n;i++) if(op[i]==Integer.MAX_VALUE) op[i]=-1;
        return op;
    }
}
