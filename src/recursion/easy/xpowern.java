package recursion.easy;

public class xpowern {

    public static long xpowern(int x,int n){
        if(n==0) return 1;
        long temp = xpowern(x, n/2);
        if(n%2 == 0) return (temp*temp)%1000000007;
        else return (x*(temp*temp%1000000007))%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(xpowern(361, 163));
    }
}
