package backtracking.basic;

public class printN1 {

    public static void printN1(int i, int N){
        if (i>N){
            return;
        }
        printN1( i+1,N);
        System.out.println(i);
    }

    public static void main(String[] args) {
        printN1( 1,10);
    }
}
