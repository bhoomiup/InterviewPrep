package binarySearch.easy;

public class NthRoot {
    public static int NthRoot(int n, int m) {
        // Write your code here.

        int l = 1;
        int h = m;
        int mid;
        while (l<=h){
            mid = (l+h)/2;
            long exp = findExp(mid, n, m);
            if(exp==m) return mid;
            else if(exp<m) l=mid+1;
            else h = mid-1;
        }
        return -1;
    }

    public static long findExp(int val,int n, int m){
        long temp = 1;
        for (int i=1; i<=n; i++){
            temp = val*temp;
            if (temp>m) return temp;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(NthRoot(4, 69));
    }
}
