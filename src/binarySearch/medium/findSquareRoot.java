package binarySearch.medium;

public class findSquareRoot {

    static long floorSqrt(long x)
    {
        // Your code here
        long l = 1;
        long h = x;
        while (l<=h){
            long m = (l+h)/2;
            if(m*m==x) return m;
            else if (m*m<x) l=m+1;
            else h=m-1;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));
    }
}
