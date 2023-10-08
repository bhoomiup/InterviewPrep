package array.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class CountOfSubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // Your code here
        int op = 0;
        HashMap<Integer, Integer> prefix_sum = new HashMap<>();
        int sum = 0;
        prefix_sum.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (prefix_sum.containsKey(sum - k)) op = op + prefix_sum.get(sum - k);
            prefix_sum.put(sum, prefix_sum.getOrDefault(sum, 0) + 1);
        }
        return op;
    }




    public static int subarraySum2(int[] nums, int k) {
        int op = 0;
        HashMap<Integer, Integer> prefix_sum = new HashMap<>();
        int sum = 0;
        prefix_sum.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (prefix_sum.containsKey(sum - k)) op += prefix_sum.get(sum - k);
            prefix_sum.put(sum, prefix_sum.getOrDefault(sum, 0) + 1);
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip = {1, -1, 0};
        int s = 0;
//        int[] ip = {1,2,3};
//        int s = 3;
        System.out.println(subarraySum(ip,  s));
}}
