package dp.easy;

public class ClimbinStairs {

//    // 2. Tabulation
//    public int climbStairs(int n) {
//        if(n==1) return 1;
//        if(n==2) return 2;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i=3; i<=n; i++){
//            dp[i]= dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }

    //3. SpaceOptimization
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int prev1 = 1;
        int prev = 2;
        for(int i=3; i<=n; i++){
            int curr = prev+prev1;
            prev1=prev;
            prev=curr;
        }
        return prev;
    }
}
