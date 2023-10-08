package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer, ArrayList<Integer>> freq = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(freq.containsKey(arr[i])){
                freq.get(arr[i]).add(i);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                freq.put(arr[i], temp);
            }
        }

        for(int i: arr){
            if(freq.containsKey(i) && freq.get(i).size()>1){
                return freq.get(i).get(0)+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] ip = {1, 5, 3, 4, 3, 5, 6};
        int[] ip = {1, 2, 3, 4};
        System.out.println(firstRepeated(ip, ip.length));
    }
}
