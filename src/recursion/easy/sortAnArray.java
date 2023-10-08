package recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sortAnArray {

    public static void sort(ArrayList<Integer> arr){
        if(arr.size()==1) return ;
        int poppedEle = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        sort(arr);
        insert(arr, poppedEle);
    }

    public static void insert(ArrayList<Integer> arr, int ele){
        if(arr.size()==0 || arr.get(arr.size()-1)<=ele){
            arr.add(ele);
            return;
        }
        int poppedEle = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        insert(arr, ele);
        arr.add(poppedEle);
    }

    public static void main(String[] args) {
        Integer[] arr_ip = {1, 5, 0, 2};
        ArrayList<Integer> ip = new ArrayList<>(Arrays.asList(arr_ip));
        Collections.addAll(ip, arr_ip);
        sort(ip);
        ip.forEach(System.out::println);
    }
}
