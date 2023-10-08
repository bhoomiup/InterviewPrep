package stack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SumOfSubArraMin {
    public static int sumSubarrayMins(int N, int[] arr) {
        // code here

        int[] rightPossibilities = new int[arr.length];
        int[] leftPossibilities = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        s.push(arr.length-1);
        rightPossibilities[arr.length-1] = 1;

        for(int i= arr.length-2; i>-1; i--){
            if(s.empty()||arr[s.peek()]<arr[i]) rightPossibilities[i] = 1;
            else{
                while (!s.empty() && arr[s.peek()]>=arr[i]) {
                    rightPossibilities[i]+=rightPossibilities[s.pop()];
                }
                rightPossibilities[i]+=1;
            }
            s.push(i);
        }
        Arrays.stream(rightPossibilities).forEach(System.out::print);
        s = new Stack<>();
        s.push(0);
        leftPossibilities[0] = 1;

        for(int i= 1; i<arr.length; i++){
            if(s.empty()||arr[s.peek()]<arr[i]) leftPossibilities[i] = 1;
            else{
                while (!s.empty() && arr[s.peek()]>arr[i]) {
                    leftPossibilities[i]+=leftPossibilities[s.pop()];
                }
                leftPossibilities[i]+=1;
            }
            s.push(i);
        }
        System.out.println();
        Arrays.stream(leftPossibilities).forEach(System.out::print);

        long op = 0;
        for(int i=0; i<arr.length; i++){
            op+=(leftPossibilities[i] * rightPossibilities[i]*arr[i]);
            op= (int) (op%1e9+7);
        }
        return (int) op;
    }























    public static int sumSubarrayMins(int[] arr) {
        int[] nextSmallest = new int[arr.length];
        int[] preSmallest = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>-1; i--){
            while (!s.isEmpty() && arr[s.peek()]>= arr[i]) s.pop();
            if(s.isEmpty()) nextSmallest[i] = 1+(arr.length-1-i);
            else nextSmallest[i] = 1+(s.peek()-1-i);
            s.add(i);
        }
        Arrays.stream(nextSmallest).forEach(System.out::print);

        System.out.println();
        s= new Stack<>();
        for(int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()]>= arr[i]) s.pop();
            if(s.isEmpty()) preSmallest[i] = 1+(i);
            else preSmallest[i] = 1+(i-s.peek()-1);
            s.add(i);
        }
        Arrays.stream(preSmallest).forEach(System.out::print);

        long sum=0;
        double mod = 1e9+7;

        for(int i =0; i<arr.length; i++){
            sum+= (arr[i]*((long) nextSmallest[i] * preSmallest[i]))%mod;
        }

        return (int )sum;


    }

    public static void main(String[] args) {
//        int[] ip = {11,81,94,43,3};
//        int[] ip = {3, 1, 2, 4};
        int[] ip = {71, 55, 82, 55};

        System.out.println(sumSubarrayMins(ip));
    }
}
