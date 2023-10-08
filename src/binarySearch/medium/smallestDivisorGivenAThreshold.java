package binarySearch.medium;
//Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
// divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned
// above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element.
// (For example: 7/3 = 3 and 10/2 = 5).

public class smallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int op = Integer.MAX_VALUE;
        int l = 1, r = findMax(nums);
        while (l<=r){
            int mid = (l+r)/2;
            int sum = getSumOfArray(nums,mid);
            if(sum<=threshold){
                op = Math.min(op, mid);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return op;
    }

    public static int findMax(int[] nums){
        int max = 0;
        for (int i: nums){
            max = Math.max(max, i);
        }
        return max;
    }

    public static int getSumOfArray(int[] nums, int divisor){
        int sum = 0;
        for(int i:nums){
            sum += Math.ceil((double) i/divisor);
        }
        return sum;
    }





























    public int smallestDivisor1(int[] nums, int threshold) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mid;

        for (int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while (min<=max){
            mid = (min+max)/2;
            if(sumOfDivisor(nums, mid)<=threshold) min = mid+1;
            else max = mid-1;
        }
        return min;
    }

    public int sumOfDivisor(int[] nums, int divident){
        int sum = 0;
        for (int i : nums) sum += (Math.ceil((double) i/divident));
        return sum;
    }

    public static void main(String[] args) {
//        int[] ip = {1,2,5,9};
//        System.out.println(smallestDivisor(ip, 6));
        int[] ip = {44,22,33,11,1};
        System.out.println(smallestDivisor(ip, 5));
    }
}
