package array.easy;

public class TransitionPoint {
    public static int transitionPoint(int arr[], int n) {
        // code here
        if (arr[arr.length-1]==0){
            return -1;
        } else if (arr[0]==1) {
            return 0;
        } else {
            int l = 0;
            int r = arr.length-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(arr[mid] == 0 && arr[mid+1]==1){
                    return mid+1;
                } else if (arr[mid]==1) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] ip = {0, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] ip = {0,0,0,1};

        System.out.println(transitionPoint(ip, ip.length));
    }
}
