package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

//    static List<Integer> nextPermutation(int N, int arr[]){
//        // code here
//        List<Integer> op = new ArrayList<>();
//        int lesser_idx = -1, greater_idx = -1;
//        for(int i=1; i<arr.length; i++){
//            if(arr[i-1]<arr[i]){
//                lesser_idx = i-1;
//                greater_idx = i;
//            }
//        }
//        if(lesser_idx == -1){
//            reverse(arr, 0, arr.length-1);
//            for (int i: arr){
//                op.add(i);
//            }
//            return op;
//        }
//        int nexGreatestIndex = nextGreatest(arr, greater_idx, arr[lesser_idx]);
//        int temp = arr[nexGreatestIndex];
//        arr[nexGreatestIndex] = arr[lesser_idx];
//        arr[lesser_idx] = temp;
//        reverse(arr, greater_idx, arr.length-1);
//        for (int i: arr){
//            op.add(i);
//        }
//        return op;
//    }
//
//    static void reverse(int[] arr, int start, int end){
//        while (start<end){
//            int temp = arr[end];
//            arr[end] = arr[start];
//            arr[start] = temp;
//            start++;
//            end--;
//        }
//    }
//
//    static int nextGreatest(int[] arr, int start, int lowest_val){
//        int op = -1;
//        for(int i=start; i<arr.length; i++){
//            if (arr[i]>lowest_val) op = i;
//        }
//        return op;
//    }

    public void nextPermutation(int[] nums) {
        int l = -1;
        int h = -1;
        for(int i=1; i< nums.length; i++){
            if(nums[i-1]<nums[i]){
                l=i-1;
                h=i;
            }
        }
        if (l==-1 && h==-1) {
            reverse(nums,0) ;
        }
        else if (h== nums.length-1) {
            swap(nums, l, h);
        }
        else {
            swap(nums, l, smallest(nums, l, h));
            reverse(nums, h);
        }
    }

    public static void swap(int[] nums, int l, int h){
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }

    public static void reverse(int[] nums, int h){
        int i =h, j=nums.length-1;
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static int smallest(int[] nums, int l, int start){
        int nextSmallIndex = start;
        for(int i=start; i<nums.length; i++){
            if(nums[i]>=nums[l]) nextSmallIndex = i;
        }
        return nextSmallIndex;
    }

    public static void main(String[] args) {
//        int[] ip = {1, 2, 3, 6, 5, 4};
//        int[] ip = {6, 1, 2, 3, 6, 5};
        int[] ip = {3, 2, 1};
        System.out.println(ip);
    }
}
