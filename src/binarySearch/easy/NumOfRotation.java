package binarySearch.easy;

public class NumOfRotation {
    public static int findKRotation(int []arr){
        // Write your code here.
        if(arr.length==1) return 0;
        int l = 0;
        int h = arr.length-1;
        int m;
        if(arr[l]<=arr[h]) return 0;
        while (l<=h){
            m = (l+h)/2;
            if(arr[l]<=arr[m]){
                if(l>0 && arr[l-1]>arr[l]) return l-1;
                else l=m+1;
            }else {
                if(m>0 && arr[m-1]>arr[m]) return m-1;
                else h=m-1;
            }
        }
        return -1;
    }
}
