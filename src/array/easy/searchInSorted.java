package array.easy;

public class searchInSorted {
    static int searchInSorted(int arr[], int N, int K)
    {

        // Your code here
        int l =0;
        int r = arr.length -1;

        while(l<=r){
            int n = (l+r)/2;
            if (arr[n] == K){
                return 1;
            }
            else if(K<arr[n]){
                r=n-1;
            }
            else if(K>arr[n]){
                l=n+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] ip = {1,2,3,4,6};
        System.out.println(searchInSorted(ip, ip.length, 6));
    }
}
