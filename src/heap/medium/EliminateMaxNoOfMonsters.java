package heap.medium;

import java.util.PriorityQueue;

public class EliminateMaxNoOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Integer> time = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            time.add((int) Math.ceil((double) dist[i]/(double) speed[i]));
        }
        int currTime = 0;
        int noOfMons = 0;
        while(!time.isEmpty()){
            int t= time.poll();
            if(t<=currTime) return noOfMons;
            noOfMons++;
            currTime++;
        }
        return noOfMons;
    }
}
