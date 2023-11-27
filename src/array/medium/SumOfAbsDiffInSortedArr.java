package array.medium;

import java.util.Arrays;

public class SumOfAbsDiffInSortedArr {
//    public static int[] getSumAbsoluteDifferences(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//        int[] prefix = new int[n];
//
//        prefix[0] = nums[0];
//        int[] suffix = new int[n];
//        suffix[n-1] = nums[n-1];
//        for(int i=1; i<n; i++){
//            prefix[i] = prefix[i-1]+nums[i];
//            suffix[n-1-i] = suffix[n-1-i+1]+nums[n-1-i];
//        }
//        for(int i=0;i<n;i++){
//            int prefixDiff = i-1>=0?Math.abs(i*nums[i] - prefix[i-1]):0;
//            int suffixDiff = i+1<n?Math.abs((n-1-i)*nums[i] - suffix[i+1]):0;
//            result[i] = prefixDiff+suffixDiff;
//        }
//        return result;
//    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int totalSum = Arrays.stream(nums).sum();
        int prefixSum = 0;
        for(int i=0;i<n;i++){
            int prefixDiff = i*nums[i] - prefixSum;
            int suffixDiff = (totalSum-nums[i]-prefixSum)-((n-1-i)*nums[i]);
            result[i] = prefixDiff+suffixDiff;
            prefixSum+=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2, 3, 5})));
    }
}
