package array.easy;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfLimitedRangeArrayElements {

    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        for(int i: arr){
//            freq.put(i, freq.getOrDefault(i,0)+1);
//        }
//
//        for(int i=1; i<N+1; i++){
//            arr[i-1] = freq.getOrDefault(i, 0);
//        }

        // Without using extra space
        int max_ele = P+1;
        for(int i=0; i<N; i++){
            if(arr[i]%max_ele<=N){
                arr[arr[i]%max_ele-1] = arr[arr[i]%max_ele-1]+max_ele;
            }
        }

        for (int i=0; i<N; i++){
            arr[i] = arr[i]/max_ele;
        }
    }

    public static void main(String[] args) {
//        int[] ip = {2, 3, 2, 3, 5};
//        frequencyCount(ip, ip.length, 5);
        int[] ip =  {2, 4, 5, 6, 8};
        frequencyCount(ip, ip.length, 10);
        Arrays.stream(ip).forEach(System.out::println);
    }
}
