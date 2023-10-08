package binarySearch.easy;

public class MinInRotatedSortedArray {

    static int findMin(int[] arr, int n)
    {
        //complete the function here
        if(arr.length==1 || arr[0]< arr[arr.length-1]){
            return arr[0];
        }
        int l = 0;
        int h = arr.length-1;

        while (l<=h){
            int mid = (l+h)/2;
            if(arr[mid-1]> arr[mid]){
                return arr[mid];
            } else if (arr[mid]>arr[mid+1] ) {
                return arr[mid+1];
            } else if (arr[mid]>arr[arr.length-1]) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return -1;
    }
//    public int findMin(int[] nums) {
//        if(nums.length==1) return nums[0];
//        int l = 0;
//        int h = nums.length-1;
//        int m;
//        if(nums[l]<=nums[h]) return nums[0];
//        while (l<=h){
//            m = (l+h)/2;
//            if(nums[l]<=nums[m]){
//                if(l>0 && nums[l-1]>nums[l]) return nums[l];
//                else l=m+1;
//            }else {
//                if(m>0 && nums[m-1]>nums[m]) return nums[m];
//                else h=m-1;
//            }
//        }
//        return -1;
//    }
    public static void main(String[] args) {
//        int[] ip = {10, 20, 30, 40, 50, 5, 7};
        int[] ip = {5 ,1 ,2 ,3, 4};
        System.out.println(findMin(ip, ip.length));
    }
}
