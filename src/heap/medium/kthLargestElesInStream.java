package heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElesInStream {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        if (k==1) return arr;
        int[] op = new int[arr.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size()<k) op[i] = -1;
            else if(pq.size()==k){
                op[i] = pq.peek();
            }
            else if(pq.size()>k) {
                pq.poll();
                op[i] = pq.peek();
            }

        }
        return op;
    }

    public static void main(String[] args) {
//        int[] ip = {1, 2, 3, 4, 5, 6};
//        int k = 4;
        int[] ip = {3, 4};
        int k = 1;
        int[] op = kthLargest(k, ip, ip.length);
        Arrays.stream(op).forEach(System.out::println);
    }
}
