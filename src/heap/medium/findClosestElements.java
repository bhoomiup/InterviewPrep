package heap.medium;

import java.util.*;

public class findClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] diff_arr = new int[arr.length];
        for(int i=0; i<arr.length; i++) diff_arr[i] = Math.abs(arr[i]-x);

        class Pair{
            int val;
            int diff;
            Pair(int val, int diff){
                this.val = val;
                this.diff = diff;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if((a.diff < b.diff) || (a.diff==b.diff && a.val < b.val))
                return 1;
            else
                return -1;
        });

        for (int i=0; i<diff_arr.length; i++){
            pq.add(new Pair(arr[i], diff_arr[i]));
            if(pq.size()>k) pq.poll();
        }

        List<Integer> op = new ArrayList<>();
        while (pq.size()!=0) op.add(pq.poll().val);
        Collections.sort(op);
        return op;
    }

    public static void main(String[] args) {
        int[] ip = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        System.out.println(findClosestElements(ip, k, x));
    }
}
