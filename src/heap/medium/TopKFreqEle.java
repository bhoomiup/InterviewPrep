package heap.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFreqEle {

    public static  int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i: nums) freq.put(i , 1+freq.getOrDefault(i, 0));

        class Data{
            int freq;
            int val;
            Data(int freq, int val){
                this.freq = freq;
                this.val = val;
            }
        }

        PriorityQueue<Data> pq = new PriorityQueue<>((a, b)-> {
            if(a.freq > b.freq) return 1;
            else if(a.freq == b.freq && a.val >b.val) return 1;
            else return -1;
        });

        for (int i : freq.keySet()){
            pq.add(new Data(freq.get(i), i));
            if(pq.size()>k) pq.poll();
        }
        int[] op = new int[k];
        int i =0;
        while (pq.size()!=0){
            op[i] = pq.poll().val;
            i++;
        }
        return op;
    }

    public static void main(String[] args) {
//        int[] ip = {1,1,1,2,2,3};
        int[] ip = {1,1,2,2,3,3,3,4};

        Arrays.stream(topKFrequent(ip, 2)).forEach(System.out::println);
    }
}
