package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class findDuplicatesInArray {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> op = new ArrayList<>();

        for(int i = 0; i<arr.length; i++){
            arr[arr[i]%n] = arr[arr[i]%n] + n;
        }

        for (int i=0; i<arr.length; i++){
            if(arr[i]/n > 1){
                op.add(i);
            }
        }
        if(op.size()==0){
            op.add(-1);
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip = {0,3,1,2};
        System.out.println(duplicates(ip, ip.length));
    }
}
