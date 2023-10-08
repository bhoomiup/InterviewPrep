package binarySearch.easy;

public class searchInsertionPositionOfKInSortedArray {
    static int searchInsertK(int Arr[], int N, int k)
    {
        // code here
        if (k<Arr[0]){
            return 0;
        } else if (k>Arr[Arr.length-1]) {
            return Arr.length;
        }
        int l = 0;
        int h = Arr.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(Arr[mid]==k){
                return mid;
            } else if (Arr[mid]<k && Arr[mid+1]>k) {
                return mid+1;
            } else if (Arr[mid]<k) {
                l = mid+1;
            }  else {
                h = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ip = {1, 3, 5, 7};
        System.out.println(searchInsertK(ip, ip.length, 6));
    }
}
