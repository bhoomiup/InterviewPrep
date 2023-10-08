package binarySearch.hard;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int k) {
        int minSum = Integer.MAX_VALUE;
        int startSum = Arrays.stream(nums).max().getAsInt();
        int endSum = Arrays.stream(nums).sum();
        while (startSum<=endSum){
            int currentSum = (startSum+endSum)/2;
            int noOfSplits = noOfSplitsForGivenSum(nums, currentSum);
            System.out.println("cuur"+currentSum+"split"+noOfSplits);
            if(noOfSplits<=k){
                endSum = currentSum-1;
                minSum = Math.min(minSum, currentSum);
            } else {
                startSum = currentSum+1;
            }
        }
        return minSum;
    }

    public static int noOfSplitsForGivenSum(int[] nums, int sum){
        int currentSum=0, splits = 0;
        for(int i: nums){
            currentSum+=i;
            if(currentSum>=sum) {
                splits++;
                currentSum = currentSum>sum?i:0;
            }
        }
        if(currentSum>0) splits++;
        return splits;
    }

















    public static int splitArray1(int[] nums, int k) {
        if(nums.length<k) return -1;
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int i: nums){
            start = Math.max(start, i);
            end+=i;
        }
        int splitSum;
        while (start<=end){
            splitSum = (start+end)/2;
            if(splitPossible(nums, k, splitSum)) start = splitSum+1;
            else  end = splitSum-1;
        }
        return start;
    }

    public static boolean splitPossible(int[] nums, int k, int splitSum){
        int sum = 0;
        for (int i: nums){
            sum+=i;
            if(sum>splitSum){
                k--;
                sum = i;
                if (k==0) return true;
            }
        }
        return  false;
    }
    public static void main(String[] args) {
        int[] ip = {10 ,20, 30, 40};
        System.out.println(splitArray1(ip, 2));
//        int[] ip = {7,2,5,10,8};
//        System.out.println(splitArray1(ip, 2));
//        System.out.println(splitArray(ip, 2));
//        int[] ip = {2,3,1,1,1,1,1};
//        System.out.println(splitArray(ip, 5));
    }
}
