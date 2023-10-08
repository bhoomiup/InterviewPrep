package recursion.medium;

public class countGoodNumbers {

    public static int countGoodNumbers(long n) {
        if(n%2==0) return (int)((xpowern(4, n/2)*xpowern(5, n/2))%1000000007);
        else return (int)((xpowern(4, n/2)*xpowern(5, (n/2)+1))%1000000007);
    }

    public static long xpowern(long x,long n){
        if(n==0) return 1;
        long temp = xpowern(x, n/2);
        if(n%2 == 0) return (temp*temp)%1000000007;
        else return (x*temp*temp)%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
