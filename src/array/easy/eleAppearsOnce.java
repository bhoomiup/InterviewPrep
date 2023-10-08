package array.easy;

public class eleAppearsOnce {
    public static int search(int A[], int N)
    {
        // your code here
        int l = 0;
        int r = N-1;
        while(l<=r){
            int n = ((l+r)/2);
            System.out.println(n);
            if(l==0 && r== 0){
                return A[0];
            }
            else if (r == N-1 && l == N-1){
                return A[N-1];
            }
            else if (A[n] == A[n+1]){
                r = n-1;
            }
            else if (A[n] == A[n-1]){
                l = n+1;
            }
            else {
                return A[n];
            }
        }
        return A[N-1];
    }

    public static void main(String[] args) {
        int[] ip = {5,5,8,8,11,11,12,12,14,14,24,27,27,28,28,31,31,45,45};
        System.out.println(search(ip, ip.length));
    }
}
