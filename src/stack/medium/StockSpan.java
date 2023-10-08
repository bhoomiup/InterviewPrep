package stack.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StockSpan {
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
            Stack<Integer> s = new Stack<>();
            int[] op = new int[price.length];
            s.push(0);
            op[0] = 1;
            for(int i=1; i<price.length; i++){
                if(price[s.peek()]>price[i]) op[i] = 1;
                else {
                    while(!s.empty() && price[s.peek()]<price[i]){
                        op[i]+=op[s.pop()];
                    }
                    op[i]+=1;
                }
                s.push(i);
            }
            return op;
    }


    public static int[] calculateSpan1(int price[], int n)
    {
        // Your code here
        int[] op = new int[price.length];
        Stack<Integer> s = new Stack<>();
        for(int i =0; i<price.length; i++){
            while(!s.isEmpty() && price[s.peek()]<=price[i]) s.pop();
            System.out.println(s);
            if(s.isEmpty() ) op[i] = 1;
            else op[i] = i-s.peek();
            s.add(i);
        }
        return op;
    }


    public static void main(String[] args) {
        int[] ip = {100, 80, 60, 70, 60, 75, 85};
//        int[] ip = {10, 4, 5, 90, 120, 80};
//        int[] op = calculateSpan1(ip, ip.length);
//        Arrays.stream(op).forEach(System.out::print);
    }
}
