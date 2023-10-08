package SlidingWindowOrPointers.medium;

import java.util.HashMap;

public class subArrayWithKDifferentIntergers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums, k)- helper(nums, k-1);
    }

    public static int helper(int[] nums, int k){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0, j = 0, count=0;
        while (j<nums.length){
            freq.put(nums[j], freq.getOrDefault(nums[j], 0)+1);
            if(freq.size()<=k) count+=(j-i+1);
            while (freq.size()>k){
                freq.put(nums[i], freq.get(nums[i])-1);
                if (freq.get(nums[i])==0) freq.remove(nums[i]);
                i++;
                if(freq.size()==k) count+=(j-i+1);
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] ip = {1,2,1,2,3};
//        System.out.println(subarraysWithKDistinct(ip, 2));
        int[] ip = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(ip, 3));
    }
}
