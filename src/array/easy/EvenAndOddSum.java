package array.easy;

public class EvenAndOddSum {
    public static int[] sumOfEvenOdd(long num, int evenSum, int oddSum) {
        /*
         * Write your code here and return array with even Sum at 0th index oddSum at
         * 1st index
         */
        int[] op = {0, 0};
        while(num!=0){
            int temp = (int) (num%10);
            if(temp%2==0) op[0]+=temp;
            else op[1]+=temp;
            num = num/10;
        }
        return op;
    }

    public static void main(String[] args) {
        int[] op = sumOfEvenOdd(2122662261, 0, 0);
        System.out.println(op[0]);
        System.out.println(op[1]);
    }
}
