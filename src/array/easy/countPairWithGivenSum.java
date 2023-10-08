package array.easy;

import java.util.HashMap;

public class countPairWithGivenSum {

    static int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i: arr){
            if(map.containsKey(k-i)){
                count += map.get(k-i);
            }
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ip = {1, 1, 1, 1};
//        int[] ip = {1, 5, 7, 1};

        System.out.println(getPairsCount(ip, ip.length, 2));
    }
}
