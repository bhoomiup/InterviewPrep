package array.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FindWinnerOfArrayGame {

//    //1. brute force
//    public static int getWinner(int[] arr, int k) {
//        int currWinner = -1;
//        int currWinCount = 0;
//        for(int i=0; i<arr.length-1; i++){
//            int tempWinner = Math.max(arr[0], arr[1]);
//            if(arr[1]>arr[0]) swap(arr, 0, 1);
//            if(currWinner == tempWinner) {
//                currWinCount++;
//            }else{
//                currWinner = tempWinner;
//                currWinCount = 1;
//            }
//            moveToEnd(arr);
//            if(currWinCount==k) return currWinner;
//        }
//        return currWinner;
//    }
//
//    public static void swap(int[] arr, int i, int j){
//        int temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
//    }
//
//    public static void moveToEnd(int[] arr){
//        for(int i=1;i<arr.length-1;i++){
//            swap(arr, i, i+1);
//        }
//    }

    // 2. Queue
//    public static int getWinner(int[] arr, int k) {
//        int currWinner = arr[0];
//        int currWinCount = 0;
//        int maxValue = arr[0];
//        Deque<Integer> q = new LinkedList<>();
//        for (int i:arr) {
//            q.add(i);
//            maxValue = Math.max(maxValue, i);
//        }
//        q.pollFirst();
//        while(true){
//            int opponent = q.poll();
//            if(currWinner>opponent){
//                currWinCount++;
//                q.offerLast(opponent);
//            }
//            else {
//                q.offerLast(currWinner);
//                currWinner = opponent;
//                currWinCount = 1;
//            }
//            if(currWinCount==k || currWinner==maxValue) return currWinner;
//        }
//    }
// 3. Optimized
//    public static int getWinner(int[] arr, int k) {
//        int currWinner = arr[0];
//        int currWinCount = 0;
//        int maxValue = arr[0];
//        for (int i:arr) maxValue = Math.max(maxValue, i);
//        for(int i=1; i<arr.length; i++){
//            int opponent = arr[i];
//            if(currWinner>opponent)currWinCount++;
//            else {
//                currWinner = opponent;
//                currWinCount = 1;
//            }
//            if(currWinCount==k || currWinner==maxValue) return currWinner;
//        }
//        return currWinner;
//    }
    public static int getWinner(int[] arr, int k) {
        int currWinner = arr[0];
        int currWinCount = 0;
        for(int i=1; i<arr.length; i++){
            int opponent = arr[i];
            if(currWinner>opponent)currWinCount++;
            else {
                currWinner = opponent;
                currWinCount = 1;
            }
            if(currWinCount==k ) return currWinner;
        }
        return currWinner;
    }

    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{2,1,3,5,4,6,7}, 2));
    }
}
