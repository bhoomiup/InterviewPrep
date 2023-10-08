package heap.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class replaceWithRank {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        class Data{
            int val;
            int index;
            Data(int val, int index){
                this.val = val;
                this.index = index;
            }
        }

        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.val));
        for(int i = 0; i< arr.length; i++){
            pq.add(new Data(arr[i], i));
        }

        int rank = 0;
        int prev = Integer.MIN_VALUE;

        while (pq.size()!=0){
            Data temp = pq.poll();
            if(temp.val != prev){
                rank+=1;
                prev = temp.val;
            }
            arr[temp.index] = rank;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ip = {20, 15, 26, 2, 98, 6};
        Arrays.stream(replaceWithRank(ip, ip.length)).forEach(System.out::println);
    }
}
