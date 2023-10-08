package array.easy;

import java.util.HashMap;
import java.util.Locale;

public class equilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {

//        // Your code here
//        HashMap<Integer, Long> sumMap = new HashMap<>();
//        long sum = 0;
//        for(int i=0; i<arr.length; i++){
//            sumMap.put(i, sum+=arr[i]);
//        }
//        for(int i=0; i<arr.length; i++){
//            if(sumMap.getOrDefault(i-1, 0L)==sum-sumMap.getOrDefault(i-1, 0L)-arr[i]){
//                return i+1;
//            }
//        }
//        return -1;

        // Constant Space
        long sum = 0;
        long reverseSum = 0;
        for(long i: arr){
            sum+=i;
        }
        for(int i=arr.length-1; i>=0; i--){
            if(sum-arr[i]-reverseSum==reverseSum){
                return i+1;
            }
            reverseSum+=arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
//        long[] ip =  {1,3,5,2,2};
        long[] ip = {1};
        System.out.println(equilibriumPoint(ip, ip.length));
    }
}
