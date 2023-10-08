package array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SubArraySumMultipleOfK {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==1) return false;
        HashMap<Integer, Integer> remainders = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            System.out.println(sum);
            System.out.println(remainders);
            if(sum>=k && sum%k==0) return true;
            if(remainders.containsKey(sum%k) && (i-remainders.get(sum%k)+1)>=1 && (sum>=k || sum==0)) return true;
            else if  (!remainders.containsKey(sum%k)){
                remainders.put(sum%k, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] ip = {23,2,6,4,7};
//        int k = 6;
//        int[] ip = {5,0,0,0};
//        int k = 3;
//        int[] ip = {1,2,12};
//        int k = 6;
        int[] ip = {0,1,0,3,0,4,0,4,0};
        int k = 5;
//        int[] ip = {0,0};
//        int k = 1;
        System.out.println(checkSubarraySum(ip, k));
    }
}
