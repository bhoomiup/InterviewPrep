package SlidingWindowOrPointers.medium;

import java.util.HashMap;

public class BinarySubArrayWithSum {


    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> sumFreq = new HashMap<>();

        for(int i:nums){
            sum += i;
            if(sum-goal==0) {
                count ++;
            }
            if(sumFreq.containsKey(sum-goal)) count += sumFreq.get(sum-goal);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ip = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(ip, 2));
//        int[] ip = {0,0,0,0,0};
//        System.out.println(numSubarraysWithSum(ip, 0));
    }
}
