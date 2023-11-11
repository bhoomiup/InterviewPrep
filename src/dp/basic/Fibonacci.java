package dp.basic;

import java.util.Arrays;

public class Fibonacci {

//    //1. Memoization
//    public int fib(int n) {
//        if(n<=1) return n;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        helper(n, dp);
//        return dp[n];
//    }
//
//    public int helper(int n, int[] dp){
//        if(n<=1) return n;
//        if(dp[n]!=-1) return dp[n];
//        return dp[n] = helper(n-1, dp)+helper(n-2, dp);
//    }

//    // 2. Tabulation
//    public int fib(int n) {
//        if(n<=1) return n;
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i=2; i<=n; i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }

    // 3. Space Optimization
    public int fib(int n) {
        if(n<=1) return n;
        int prev1 = 0;
        int prev = 1;
        for(int i=2; i<=n; i++){
            int curr = prev+prev1;
            prev1=prev;
            prev=curr;
        }
        return prev;
    }
}
