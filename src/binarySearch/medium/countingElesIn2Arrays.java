package binarySearch.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class countingElesIn2Arrays {

    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        // add your code here
        ArrayList<Integer> op = new ArrayList<>();
        arr2 = Arrays.stream(arr2).sorted().toArray();
        Arrays.stream(arr2).forEach(x-> System.out.print(x+ ", "));
        System.out.println();
        for(int i : arr1){
            int foundIndex = binarySearchIndex(arr2, i);
            System.out.println(foundIndex);
            op.add(foundIndex!=-1?foundIndex+1:0);
        }
        return op;
    }

    public static int binarySearchIndex(int[] arr, int ele){
        int l = 0;
        int h = arr.length-1;
        if(arr[h]<ele) return h;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==ele) {
                if(mid!=arr.length-1 && arr[mid+1]==ele) l=mid+1;
                else return mid;
            }
            else if (arr[mid]<ele && arr[mid+1]> ele) return mid;
            else if (arr[mid]<ele) l = mid+1;
            else h=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4,7,9};
//        int[] arr2 = {0,1,2,1,1,4};
//        int[] arr1 = {4,8,7,5,1};
//        int[] arr2 = {4,48,3,0,1,1,5};
        int[] arr1 = {302,9930,2776,2306,9271,11185,5021,6343,4522,7871,6270,5829,4375,4372,5097,5311,1584,2089,9161,7435,11154,2365,1253,4373,4031,851,4948,1150,5740,10523,2765,3430,8705,7789,6806,136,4256,1086,5351};
        int[] arr2 = {10383,3744,8909,9807,9758,1819,7387,6422};
        System.out.println(countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length));
    }
}
