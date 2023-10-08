package array.easy;

import java.util.Arrays;

public class Sort012 {
    public static void sort012(int a[], int n)
    {
        // code here
        int l=0;
        int m=0;
        int h=a.length-1;
        while(m<=h){
            if(a[m]==0){
                int temp = a[l];
                a[l] = a[m];
                a[m] = temp;
                l++;
                m++;
            } else if (a[m]==2) {
                int temp = a[h];
                a[h] = a[m];
                a[m] = temp;
                h--;
            } else{
                m++;
            }
        }
    }





    public static void sortColors(int[] nums) {
        int zeroPlace= 0 , i = 0;
        int twoPlace = nums.length -1;
        while (i<twoPlace){
            if(nums[i]==0) {
                swap(nums, i, zeroPlace);
                zeroPlace++;
                i++;
            } else if (nums[i]==2){
                swap(nums, i, twoPlace);
                twoPlace--;
            } else i++;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }


    public static void main(String[] args) {
        int[] ip = {0, 2, 1, 2, 0};

//        sort012(ip, ip.length);
        sortColors(ip);
        Arrays.stream(ip).forEach(System.out::print);
    }
}
