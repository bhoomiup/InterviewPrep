package array.easy;

import java.util.HashMap;

public class FindSingleEle {
    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        for(int num:nums) freq.put(num, freq.getOrDefault(num, 0)+1);
//        int singleNum = 0;
//        for(int num: freq.keySet()) {
//            if (freq.get(num)==1){
//                singleNum= num;
//                break;
//            }
//        }
//        return singleNum;
        // XOR cancels same nums and the single ele will be remaining
        System.out.println();
        int XOR1 = 0;
        for(int num: nums) XOR1 = XOR1 ^ num;
        return XOR1;
    }
}
