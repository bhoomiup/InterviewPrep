package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Fsecure {

    // Round 1
    // ip = ["eat","tea","tan","ate","nat","bat"]
    // op = [["bat"],["nat","tan"],["ate","eat","tea"]]
    // "aet" : {"ate","eat","tea}

    public static List<List<String>> groupAnagrams(List<String> ip){
        HashMap<String, List<String>> op = new HashMap<>();
        for(String s: ip){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(!op.containsKey(key)) {
                List<String> set = new ArrayList<>();
                set.add(s);
                op.put(key, set);
            }else {
                op.get(key).add(s);
            }
        }
        return  op.values().stream().toList();
    }

    // Round 2
    // ip = [3, 4, 8, 2, 5];
    // 1. [3, 4, 5, 2, 8]
    // 2. [3, 4, 2, 5, 8]
    // 3. [3, 2, 4, 5, 8]
    static int findNthLargest(int[] arr, int k){
        int i;
        int n = arr.length-1;
        for(i=1; i<=k; i++){
            swap(arr, findMax(arr, 0, n), n);
            n--;
        }
        return arr[n+1];

    }

    static int findMax(int[] arr, int start, int end){
        int index = start;
        for (int i = start; i<=end; i++) {
            if(arr[i]>arr[index]) index = i;
        }
        return index;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // ip = [3, 4, 8, 2, 5]; x = 3
        //          ans
        //       2, 3, 4, 5, 8
        //       0  1  2  3  4
        //       l     m     h
        // {4, 5, 8}


        //


        // 1. [3, 4, 5, 2, 8]
        // 2. [3, 4, 2, 5, 8]
        // 3. [3, 2, 4, 5, 8]
        int[] ip = {3, 4, 8, 2, 5};
        // 2, 3, 4, 5, 8
        System.out.println(findNthLargest(ip, 5));


        // "ababaxababa"
        //  i
        // "kaak"
        // 2 -> 3-> 4-> 1-> 5
        // i    i
        // j         j
        // 2, 1
        // stack<Pair<val, min>>
        //
        // min ele = 1

    }
}
