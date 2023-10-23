package binarySearch.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccuranceOfX {

    static ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> op = new ArrayList<>();

        int l =0;
        int h =arr.length-1;

        if(arr[0]==x){
            op.add(0L);
        }
        else{
            while(l<=h){
                int mid = (l+h)/2;
                if(arr[mid]== x && arr[mid-1]<x){
                    op.add((long) mid);
                    break;
                } else if(arr[mid]<x){
                    l = mid+1;
                } else {
                    h = mid - 1;
                }
            }
        }


        l =0;
        h =arr.length-1;

        if (arr[arr.length-1]==x){
            op.add((long) (arr.length-1));
        }
        else{
            while(l<=h){
                int mid = (l+h)/2;
                System.out.println(mid);
                if(arr[mid]== x && arr[mid+1]>x){
                    op.add((long) mid);
                    break;
                } else if(arr[mid]<=x){
                    l = mid+1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return op;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] op = new int[]{-1, -1};
        if(nums.length==0) return op;
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m]==target){
                if(m==0 || nums[m-1]<nums[m]) {
                    op[0]=m;
                    break;
                }else{
                    h=m-1;
                }
            }else if(nums[m]<target) l=m+1;
            else h=m-1;
        }
        l=0;
        h=nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m]==target){
                if(m==nums.length-1 || nums[m+1]>nums[m]) {
                    op[1]=m;
                    break;
                }else{
                    l=m+1;
                }
            }else if(nums[m]<target) l=m+1;
            else h=m-1;
        }
        return op;
    }

    public static void main(String[] args) {
//        long[] ip = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
//        System.out.println(find(ip, ip.length, 5));
//        long[] ip = {6, 9};
//        System.out.println(find(ip, ip.length, 9));
//        int[] ip = {5,7,7,8,8,10};
        int[] ip = {2, 2};
        System.out.println(Arrays.toString(searchRange(ip, 2)));
    }
}
