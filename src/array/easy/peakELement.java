package array.easy;

public class peakELement {
    public static int peakElement(int[] arr,int n)
    {
        if(arr.length==1){
            return 0;
        } else if (arr[0]>arr[1]) {
            return 0;
        } else if (arr[arr.length-1]> arr[arr.length-2]) {
            return arr.length-1;
        } else {
            int l = 1;
            int h = arr.length-2;
            while (l<=h){
                int mid = ((l+h)/2);
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                    return mid;
                } else if (arr[mid-1] > arr[mid+1]) {
                    h = mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] ip = {1, 3, 5, 6, 4};
//        int[] ip = {1, 3, 5};
//        int[] ip = {7, 3, 5, 6, 4};
        int[] ip ={9,14,10,10,1,2,1,7,10,10,14,19,9};
        System.out.println(peakElement(ip, ip.length));
    }
}
