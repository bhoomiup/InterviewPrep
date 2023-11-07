package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PythogoreonTriplent {
    boolean checkTriplet(int[] arr, int n) {
        // code here
//        arr=Arrays.stream(arr).map(i->i*i).sorted().toArray();
//        for(int i=n-1;i>=0;i--){
//            int j=0;
//            int k=i-1;
//            while(j<k){
//                int sum = arr[j]+arr[k];
//                if(sum==arr[i]) return true;
//                else if (sum<arr[i]) j++;
//                else k--;
//            }
//        }
//        return false;

        Set<Integer> squares= new HashSet<>();
        for(int i: arr) squares.add(i*i);
        for(int i=0;i<arr.length;i++){
            int a = arr[i]*arr[i];
            for(int j=i+1;j<arr.length;j++){
                int b = arr[j]*arr[j];
                if(squares.contains(a+b)) return true;
            }
        }
        return false;
    }
}
