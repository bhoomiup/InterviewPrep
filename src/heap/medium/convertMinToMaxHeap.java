package heap.medium;

import java.util.Arrays;

public class convertMinToMaxHeap {

    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        int n1 = (N/2)-1;
        for(int i=n1; i>=0; i--) {
            maxHeapify(arr, i);
        }
    }

    static void maxHeapify(int[] arr, int i){
        int li = (2*i)+1;
        int ri = (2*i)+2;
        int greatest = i;
        if(li<arr.length && arr[li]>arr[greatest]) greatest = li;
        if(ri<arr.length && arr[ri]>arr[greatest]) greatest = ri;
        if(greatest!=i){
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
            maxHeapify(arr, greatest);
        }

    }

    public static void main(String[] args) {
        int[] ip = {3, 4, 8, 11, 13};
        convertMinToMaxHeap(ip.length, ip);
        Arrays.stream(ip).forEach(System.out::println);
    }
}
