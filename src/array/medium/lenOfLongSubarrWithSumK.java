package array.medium;

import java.util.HashMap;

public class lenOfLongSubarrWithSumK {
//    public static int lenOfLongSubarr (int A[], int N, int K) {
//        //Complete the function
//        HashMap<Integer, Integer> prefixSum = new HashMap<>();
//        prefixSum.put(0, -1);
//        int maxLength = 0;
//        int tempSum = 0;
//        for (int i =0 ; i< A.length; i++){
//            tempSum += A[i];
//            if(!prefixSum.containsKey(tempSum)){
//                prefixSum.put(tempSum, i);
//            }
//            if(prefixSum.containsKey(tempSum-K)){
//                maxLength = Math.max(maxLength, i- prefixSum.get(tempSum-K));
//            }
//        }
//        System.out.println(prefixSum);
//        return maxLength;
//    }


    // 24-07-2023
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> mp =  new HashMap<>();
        mp.put(sum, -1);
        for(int i=0; i<N; i++){
            sum+=A[i];
            if(mp.containsKey(sum-K)) maxLen = Math.max(maxLen, i-mp.get(sum-K));
            if(!mp.containsKey(sum)) mp.put(sum, i);
        }
        return maxLen;
    }
















    public static void main(String[] args) {
        int[] ip =  {1, 4, 3, 3, 5, 5};
        System.out.println(lenOfLongSubarr(ip, ip.length, 16));
    }
}
