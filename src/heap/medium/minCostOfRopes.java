package heap.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class minCostOfRopes {

    static long minCost(long arr[], int n)
    {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i: arr) {
            pq.add(i);
        }

        long count = 0;
        long temp = 0;
        ArrayList<Long> op = new ArrayList<>();
        while(pq.size()!=0){
            temp +=  pq.poll();
            count++;
            if (count==2) {
                op.add(temp);
                pq.add(temp);
                count=0;
                temp=0;
            }
        }
        return op.stream().mapToLong(a->a).sum();
    }

    public static void main(String[] args) {
        long[] ip = {4, 3, 2, 6};
//        long[] ip = {4, 2, 7, 6, 9};

        System.out.println(minCost(ip, ip.length));
    }
}
