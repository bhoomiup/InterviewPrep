package array.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class subArrayWithGivenSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        ArrayList<Integer> op = new ArrayList<>();
        op.add(-1);
        HashMap<Integer, Integer> prefix_sum = new HashMap<>();
        int sum = 0;
        prefix_sum.put(0, -1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(prefix_sum.containsKey(sum-s)){
                op.set(0, prefix_sum.get(sum-s)+2);
                op.add(i+1);
                return op;
            }
            prefix_sum.put(sum, i);
        }
        return op;
    }

    public static void main(String[] args) {
//        int[] ip = {1,2,3,7,5};
//        int s = 12;
        int[] ip = {1,2,3,4,5,6,7,8,9,10};
        int s = 15;
        System.out.println(subarraySum(ip, ip.length, s));
    }
}
