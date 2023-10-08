package array.easy;

import java.util.Arrays;

public class pushZerosToEnd {
    static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int i = 0;
        int j = 0;
        while(j< arr.length){
            if(arr[i]==0){
                if(arr[j]==0){
                    j++;
                    continue;
                }
                else{
                    int val = arr[j];
                    arr[j] = arr[i];
                    arr[i] = val;
                }
            }
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] ip = {3, 5, 0, 1, 2, 0, 0, 4, 1};
        pushZerosToEnd(ip, ip.length);
        Arrays.stream(ip).forEach(i-> System.out.println(i));
    }
}
