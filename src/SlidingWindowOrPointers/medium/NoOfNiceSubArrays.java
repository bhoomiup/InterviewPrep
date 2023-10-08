package SlidingWindowOrPointers.medium;

import java.util.HashMap;

public class NoOfNiceSubArrays {

//     A continuous subarray is called nice if there are k odd numbers on it.
    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i=0; i< nums.length;  i++){
            if (nums[i]%2==0) nums[i]=0;
            else nums[i] = 1;
        }

        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        int i = 0;
        int count = 0;
        int sum = 0;
        while (i<nums.length){
            sum+=nums[i];
            if(sumFreq.containsKey(sum-k)){
                count+=sumFreq.get(sum-k);
            }
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0)+1);
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] ip = {1,1,2,1,1};
//        System.out.println(numberOfSubarrays(ip, 3));
//        int[] ip = {2,2,2,1,2,2,1,2,2,2};
//        System.out.println(numberOfSubarrays(ip, 2));
        int[] ip = {2,4,6};
        System.out.println(numberOfSubarrays(ip, 1));
    }
}
