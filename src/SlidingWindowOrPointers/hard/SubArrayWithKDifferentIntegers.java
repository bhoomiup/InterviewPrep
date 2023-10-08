package SlidingWindowOrPointers.hard;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegers {

//    public static int subarraysWithKDistinct(int[] nums, int k) {
//        return helper(nums, k)-helper(nums,k-1);
//    }
//    public static int helper(int[] nums,int k){
//        int count = 0;
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        int i= 0; int j = 0;
//        while(j<nums.length){
//            freq.put(nums[j], freq.getOrDefault(nums[j], 0)+1);
//            if(freq.size()<=k){
//                count += j-i+1;
//            }
//            else{
//                while (freq.size()>k){
//                    freq.put(nums[i], freq.get(nums[i])-1);
//                    if (freq.get(nums[i])==0) freq.remove(nums[i]);
//                    i++;
//                }
//                count += j-i+1;
//            }
//            j++;
//        }
//        return count;
//    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }


    // at most means subArray can have 1-> k distinct elements
    // So if we find all sub arrays having k distinct eles and subtract with num of subArrays having k-1 distinct eles,
    // then we can get exactly k distinct eles
    public static int atMostKDistinct(int[] nums, int k){
        int i = 0, j = 0, n = nums.length, count = 0, op = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(j<n){
            mp.put(nums[j] , mp.getOrDefault(nums[j], 0)+1);
            while (mp.size()>k){
                mp.put(nums[i] , mp.get(nums[i])-1);
                if (mp.get(nums[i])==0) mp.remove(nums[i]);
                i++;
            }
            count+=(1+j-i);
            op = Math.max(count, op);
            j++;
        }
        return count;
    }

    // Longest substring with atmost K distinct char
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int i = 0, j = 0, n = str.length(), count = 0, op = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(j<n){
            mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0)+1);
            while (mp.size()>k){
                mp.put(str.charAt(i) , mp.get(str.charAt(i))-1);
                if (mp.get(str.charAt(i))==0) mp.remove(str.charAt(i));
                i++;
            }
            count+=(1+j-i);
            op = Math.max((1+j-i), op);
            j++;
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(ip, 2));
    }
}
