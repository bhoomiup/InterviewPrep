package array.easy;

import java.util.Arrays;

public class missingNumber {
    public static int missingNumber(int A[], int N)
    {
        Arrays.stream(A).forEach(System.out::println);

        // Your code goes here
        int sum = 0;
        // 1. find the sum of given array
        for(int i:A) sum+=i;
        // 2. find the sum of N digits
        int totalSum = (N*(N+1))/2;
        return totalSum-sum;
    }

    public static void main(String[] args) {
        int[] ip = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(ip, ip.length));
    }
}
