package binarySearch.easy;

public class SqrtOfNum {

    public static int sqrtN(long N) {
        /*
         * Write your code here
         */

        long l = 0;
        long h = N;
        long m;
        while (l<=h){
            m = (l+h)/2;
            if(m==N/m) return (int) m;
            else if(m<N/m) l=m+1;
            else h = m-1;
        }
        return (int)h;
    }
}
