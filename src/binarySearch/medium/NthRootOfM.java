package binarySearch.medium;

public class NthRootOfM {

    public static int NthRoot(int n, int m)
    {
        int l = 1;
        int h = m;
        while (l<=h){
            int mid = (l+h)/2;
            double temp=1;
            System.out.println("mis"+mid);
            int N = n;
            while (N>0){
                temp *= mid;
                N-=1;
            }
            if(temp==m) return (int)mid;
            else if (temp<m) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(6, 4096));
    }
}
