package binarySearch.easy;

public class FloorInSortedArray {
    static int findFloor(long arr[], int n, long x)
    {
        if (x<arr[0]){
            return -1;
        } else if(x>arr[arr.length-1]){
            return arr.length-1;
        }
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==x){
                return mid;
            } else if (arr[mid]<x && arr[mid+1]>x) {
                return mid;
            } else if (arr[mid]<x) {
                l = mid+1;
            }  else {
                h = mid-1;
            }
        }
        return arr.length-1;
    }

    public static void main(String[] args) {
//        long[] ip = {1,2,8,10,11,12,19};
//        System.out.println(findFloor(ip, ip.length, 5));
        long[] ip = {66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130};
        System.out.println(findFloor(ip, ip.length, 106));
    }
}
