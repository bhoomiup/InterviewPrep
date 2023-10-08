package recursion.basic;

import java.util.Arrays;

public class reverseArray {

    public static void reverseArray(int left, int right, int[] arr){
        if(left>=right){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArray(left+1, right-1, arr);
    }
    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 4, 5, 6, 7};
        reverseArray(0, ip.length-1, ip);
        Arrays.stream(ip).forEach(System.out::println);

    }
}
