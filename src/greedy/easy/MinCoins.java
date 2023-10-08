package greedy.easy;

import java.util.*;

public class MinCoins {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        List<Integer> coins = Arrays.asList(1000, 500, 100, 50, 20, 10, 5, 2, 1);
        int i = 0;
        List<Integer> op = new ArrayList<>();
        while(n>0){
            int temp = coins.get(i);
            if(temp>n) i++;
            else{
                op.add(temp);
                n-=temp;
            }
        }
        return op;
    }

    public int minCoins(int[] coins, int M, int V)
    {
        // Your code goes here
        Arrays.sort(coins);
        int i = coins.length-1;
        int op = 0;
        while(M>0){
            int temp = coins[i];
            if(temp>M) i--;
            else{
                op++;
                M-=temp;
            }
        }
        return op;
    }

}
