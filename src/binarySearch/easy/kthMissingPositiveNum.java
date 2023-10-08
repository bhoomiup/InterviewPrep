package binarySearch.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class kthMissingPositiveNum {
    public static int findKthPositive(int[] arr, int k) {
        int[] missingCount = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            missingCount[i] = arr[i]-(i+1);
        }
        if(missingCount[0]>=k) return k;
        else if (missingCount[missingCount.length-1]<k) return arr[arr.length-1]+k-missingCount[missingCount.length-1];
        else{
            int i = 0, j = arr.length-1;
            while (i<=j){
                int mid = (i+j)/2;
                if (missingCount[mid]>=k&&missingCount[mid-1]<k) return arr[mid-1]+(k-missingCount[mid-1]);
                else if(missingCount[mid]>=k) j=mid-1;
                else i=mid+1;
            }
            return arr[arr.length-1]+k;
        }

    }


    public int findKthPositive1(int[] arr, int k) {
        int n = arr.length-1;
        if(k<arr[0]) return k;
        else if(arr[n]-(n+1)<k) return arr[n]+(k-(arr[n]-(n+1)));
        int l = 0;
        int h = n;
        int m ;
        while (l<=h){
            m = (l+h)/2;
            if(arr[m]-(m+1)<k) l = m+1;
            else h = m-1;
        }
            return arr[h]+(k-(arr[h]-(h+1)));
    }


    public static void main(String[] args) {
        int[] ip = {2,3,4,7,11};
        System.out.println(findKthPositive(ip, 5));
//        int[] ip = {5,6,7,8,9};
//        System.out.println(findKthPositive(ip, 9));
//        int[] ip = {1,2,3,4};
//        System.out.println(findKthPositive(ip, 2));
//        int[] ip = {2};
//        System.out.println(findKthPositive(ip, 1));
//        int[] ip = {6,7,10,20,28,29,33,37,39,40,49,53,55,72,75,76,85,87,88,94,106,107,119,120,129,142,147,152,157,159,161,173,178,183,187,188,193,199,202,212,215,224,227,230,237,239,246,251,256,260,266,268,273,277,279,281,291,297,298,310,312,314,315,321,324,326,329,341,342,348,355,367,370,374,387,389,394,413,420,424,429,446,447,458,460,464,467,473,477,478,498,500,501,503,514,515,523,525,528,529,531,535,539,555,566,569,572,583,588,591,596,602,604,605,606,610,611,616,619,622,623,631,632,640,642,645,647,661,680,684,685,687,694,696,698,714,717,720,726,734,738,742,745,753,770,775,780,781,783,787,788,798,806,821,835,852,865,873,888,897,926,932,935,939,945,956,966,967,969,973,979,980,986,992,995,997};
//        System.out.println(findKthPositive(ip, 96));
    }
}