package recursion.medium;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class countSubSequenceWithSumK {

    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        ArrayList<Integer> op = new ArrayList<>();
        return helper(arr, op, 0, 0, sum);
    }

    public static int helper(int[] ip, ArrayList<Integer> op, int index, int sum, int k){
        if(index==ip.length ) {
            if(sum==k) {
                return 1;
            }
            return 0;
        }
        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 =  new ArrayList<>(op);
        op2.add(ip[index]);
        return ((helper(ip, op1, index+1, sum, k)) + (helper(ip, op2, index+1, sum+ip[index], k)))%1000000007;
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 1};
        perfectSum(ip, ip.length, 2);
    }
}
