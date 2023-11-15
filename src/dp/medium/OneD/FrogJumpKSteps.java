package dp.medium.OneD;

public class FrogJumpKSteps {

//    // 1. Recursion
//    public static int minimizeCost(int n, int k, int []height){
//        // Write your code here.
//        // 1. Recursion
//        return helper(n-1,k, height);
//    }
//
//    public static int helper(int index, int k, int[] heights){
//        if(index<=0) return 0;
//        int minCost = Integer.MAX_VALUE;
//        for(int i=1; i<=k; i++){
//            int cost = (index-i)>=0 ? helper(index-i,k, heights)+ Math.abs(heights[index-i]-heights[index]): Integer.MAX_VALUE;
//            minCost = Math.min(minCost, cost);
//        }
//        return minCost;
//    }

//    // 2. Memoization
//    public static int minimizeCost(int n, int k, int []height){
//        // Write your code here.
//        // Write your code here..
//        int[] dp = new int[n];
//        return helper(n-1,k,dp, height);
//
//    }
//
//    public static int helper(int index, int k, int[] dp, int[] heights){
//        if(index<=0) return 0;
//        int minCost = Integer.MAX_VALUE;
//        for(int i=1; i<=k; i++){
//            if(dp[index]!=0) return dp[index];
//            int cost = (index-i)>=0 ? helper(index-i,k, dp, heights)+ Math.abs(heights[index-i]-heights[index]): Integer.MAX_VALUE;
//            minCost = Math.min(minCost, cost);
//
//        }
//        return dp[index]=minCost;
//    }

    // 3. Tabulation
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int[] dp = new int[n];
        for (int i=1; i<n;i++){
            int minCost = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                int cost = (i-j)>=0?dp[i-j]+ Math.abs(height[i-j]-height[i]):Integer.MAX_VALUE;
                minCost = Math.min(minCost, cost);
            }
            dp[i] = minCost;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(minimizeCost(4, 2,  new int[]{10, 40, 30, 10}));
    }

}
