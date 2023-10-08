package recursion.basic;

public class sumOfNNums {



    // 1. parameterized/ Recursion tree/ input-output method
    public static void sumOfNNums(int N, int sum){
        if(N==0){
            System.out.println(sum);
            return;
        }
        sumOfNNums(N-1, sum+N);
    }

    //    // 2. functional/ Induction-Base-Hypothesis method
//    public static int sumOfNNums(int N){
//        if(N==0){
//            return 0;
//        }
//        return N + sumOfNNums(N-1);
//    }

    public static void main(String[] args) {
//        System.out.println(sumOfNNums(3));
        sumOfNNums(3, 0);

    }
}
