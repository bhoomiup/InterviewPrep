package sorting.hard;

import java.util.ArrayList;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    static int mergeSort(int arr[], int start, int end)
    {
        // Your Code Here
        int count = 0;
        if (start >= end) return count;

        int mid = (start+end)/2;
        count+=mergeSort(arr, start, mid);
        count+=mergeSort(arr, mid+1, end);
        count+=countReverse(arr, start, end, mid);
        merge(arr, start, end, mid);
        return count;
    }

    static int countReverse(int arr[], int start, int end, int mid){
        int count = 0;
        int j = mid;
        for(int i = start; i<=mid; i++){
            while (j<=end){
                if(arr[i]>2*arr[j]) count+=(j-mid+1);
                j++;
            }
        }
        return count;
    }

    static void merge(int arr[], int start, int end, int mid){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid+1;
        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else {
                temp.add(arr[j]);
                j++;
            }
        }
        while (i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while (j<=end){
            temp.add(arr[j]);
            j++;
        }
        for (int x = start; x <= end; x++) {
            arr[x] = temp.get(x - start);
        }
    }

}
