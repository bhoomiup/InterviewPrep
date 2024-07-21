package array;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int op = 0, temp;
        for(int i: nums){
            temp = mp.getOrDefault(k-i, 0);
            if(temp>0) {
                op++;
                mp.put(k-i, temp-1);
            }
            else mp.put(i,  mp.getOrDefault(i, 0)+1);
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }
}
