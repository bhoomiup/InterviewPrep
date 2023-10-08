package sorting.medium;

import java.util.ArrayList;

public class InversionCount {


    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr, 0, (int)N-1);
    }
    static long mergeSort(long arr[], int start, int end)
    {
        // Your Code Here
        long count = 0;
        if (start >= end) return count;

        int mid = (start+end)/2;
        count+=mergeSort(arr, start, mid);
        count+=mergeSort(arr, mid+1, end);
        count+=merge(arr, start, end, mid);
        return count;
    }
    static long merge(long arr[], int start, int end, int mid){
        ArrayList<Long> temp = new ArrayList<>();
        long count = 0;
        int i = start;
        int j = mid+1;
        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else {
                temp.add(arr[j]);
                count+=(mid-i+1);
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
        return count;
    }

    public static void main(String[] args) {
        long[] ip = {2, 4, 1, 3, 5};
//        long[] ip = {2, 3, 4, 5, 6};

        System.out.println(inversionCount(ip, ip.length));
    }
}
