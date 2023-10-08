package array.easy;

import java.util.Arrays;

public class WaveArray {

    public static void convertToWave(int n, int[] a) {
        // code here
        int i =0;
        int j =1;

        while(j< a.length) {
            int val = a[i];
            a[i] = a[j];
            a[j] = val;

            i += 2;
            j += 2;

        }
    }

    public static void main(String[] args) {
        int[] ip =  {2,4,7,8,9,10};
        convertToWave(ip.length, ip);
        Arrays.stream(ip).forEach(System.out::println);
    }
}
