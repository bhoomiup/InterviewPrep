package array.easy;

import java.util.Arrays;

public class Segregate0s1s {

    public static void segregate0and1(int[] arr, int n) {
        // code here
        int i = 0, j = n-1;
        while(i<j) {
            if (arr[i] == 0) {
                i++;
                continue;
            }
            arr[i] = arr[j];
            arr[j] = 1;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] ip = {0, 1, 0, 1, 1, 0, 0, 1};
        segregate0and1(ip, ip.length);
        Arrays.stream(ip).forEach(System.out::println);
    }
}
