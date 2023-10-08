package array.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestSubArrayWithSum0 {

    static int maxLen(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        int maxLength = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (!prefixSum.containsKey(tempSum)) {
                prefixSum.put(tempSum, i);
            } else {
                maxLength = Math.max(maxLength, i - prefixSum.get(tempSum));
            }
        }
        return maxLength;
    }

    //28-07-2023
    int maxLen2(int arr[], int n)
    {
        // Your code here
        int op = Integer.MIN_VALUE;
        HashMap<Integer, Integer> prefix_sum = new HashMap<>();
        int sum = 0;
        prefix_sum.put(0, -1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(prefix_sum.containsKey(sum))op = Math.max(op, i-prefix_sum.get(sum));
            if(!prefix_sum.containsKey(sum)) prefix_sum.put(sum, i);
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(ip, ip.length));
    }
}
