package heap.medium;

import javax.imageio.stream.IIOByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKSortedArray {

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        // Method - 1:
//        // Write your code here.
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for(int[] i : arr){
//            for(int j: i){
//                pq.add(j);
//            }
//        }
//
//        ArrayList<Integer> op = new ArrayList<>();
//        while(pq.size()!=0){
//            op.add(pq.poll());
//        }
//        return op;

        class Data{
            int val;
            int row;
            int col;
            Data(int val,int row,int col){
                this.val = val;
                this.row = row;
                this.col = col;
            }
        }

        // Method -2:

        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(int i=0; i<arr.length; i++){
            Data temp = new Data(arr[i][0], i, 0);
            pq.add(temp);
        }
        ArrayList<Integer> op = new ArrayList<>();
        while (pq.size()!=0){
            Data temp = pq.poll();
            op.add(temp.val);
            int row = temp.row;
            int col = temp.col;
            if(col< arr[row].length-1){
                Data temp1 = new Data(arr[row][col+1], row, col+1);
                pq.add(temp1);
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int[][] ip={{1,2,3,4},{2,2,3,4},
            {5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArrays(ip, ip.length));
    }
}
