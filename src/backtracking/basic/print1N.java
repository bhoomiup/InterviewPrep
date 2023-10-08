package backtracking.basic;

public class print1N {
    public static void print1N(int N){
        if (N<1){
            return;
        }
        print1N(N-1);
        System.out.println(N);
    }

    public static void main(String[] args) {
        print1N( 10);
    }
}
