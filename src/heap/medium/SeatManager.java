package heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SeatManager {
    PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++) pq.add(i);
    }

    public int reserve() {
        return this.pq.poll();
    }

    public void unreserve(int seatNumber) {
        this.pq.add(seatNumber);
    }

}
