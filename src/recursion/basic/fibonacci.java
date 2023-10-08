package recursion.basic;

public class fibonacci {

    public static int nthFibonacciNumber(int N){
        if (N==0) return 0;
        else if (N==1) return 1;
        return nthFibonacciNumber(N-1)+nthFibonacciNumber(N-2);
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(5));
    }
}
