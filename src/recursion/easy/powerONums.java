package recursion.easy;

public class powerONums {

    public static long power(int N, int R){
        if (R==1) return N;
        return (N*power(N, R-1))%1000000007;
    }

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        else if(n==1) return x;
        long N = n;
        if(N<0) {
            x = 1/x;
            N= -1*N;
        }
        return helper(x, N);
    }

    public double helper(double x, long n) {
        if(n==1) return x;
        if (n % 2 == 0) return myPow(x*x, (int) (n/2));
        else return x * myPow(x, (int) (n-1));
    }



    public static void main(String[] args) {
        System.out.println(power(12, 21));
    }
}
