package recursion.basic;

public class print1N {

//    public static void print1N(int i, int N){
//        if (i>N){
//            return;
//        }
//        System.out.println(i);
//        i++;
//        print1N(i, N);
//    }

    // Backtracking
    public static void print1N(int N){
        if (N<1){
            return;
        }
        print1N( N-1);
        // perform task after recursion call
        System.out.println(N);

    }

    public static void main(String[] args) {
        print1N( 10);
    }
}
