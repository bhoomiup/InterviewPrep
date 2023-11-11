package dp.easy;

public class FrogJump {
    // 1. Recursion
//    public static int frogJump(int n, int heights[]) {
//
//        // Write your code here..
//        return helper(n-1, heights);
//
//    }
//
//    public static int helper(int index, int[] heights){
//        if(index<=0) return 0;
//        int left = helper(index-1, heights)+ Math.abs(heights[index-1]-heights[index]);
//        int right = (index-2>=0)?helper(index-2, heights)+ Math.abs(heights[index-2]-heights[index]):Integer.MAX_VALUE;
//        return Math.min(left, right);
//    }

//    // 2. Memoization
//    public static int frogJump(int n, int heights[]) {
//
//    // Write your code here..
//    int[] dp = new int[n];
//    return helper(n-1, heights, dp);
//
//}
//
//    public static int helper(int index, int[] heights, int[] dp){
//        if(index<=0) return 0;
//        if(dp[index]!=0) return dp[index];
//        int left = helper(index-1, heights, dp)+ Math.abs(heights[index-1]-heights[index]);
//        int right = (index-2>=0)?helper(index-2, heights, dp)+ Math.abs(heights[index-2]-heights[index]):Integer.MAX_VALUE;
//        return dp[index] = Math.min(left, right);
//    }

//    //3. Tabulation
//    public static int frogJump(int n, int heights[]) {
//
//        // Write your code here..
//        int[] dp = new int[n];
//        for(int i=1; i<n;i++){
//            int left = dp[i-1]+Math.abs(heights[i-1]-heights[i]);
//            int right = (i-2)>=0? dp[i-2]+Math.abs(heights[i-2]-heights[i]):Integer.MAX_VALUE;
//            dp[i]=Math.min(left, right);
//        }
//        return dp[n-1];
//    }

    // 4. Space Optimization
        public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int prev1 = Integer.MAX_VALUE;
        int prev=0;
        int curr;
        for(int i=1; i<n;i++){
            int left = prev+Math.abs(heights[i-1]-heights[i]);
            int right = (i-2)>=0? prev1+Math.abs(heights[i-2]-heights[i]):Integer.MAX_VALUE;
            curr=Math.min(left, right);
            prev1 = prev;
            prev= curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        System.out.println(frogJump(4, new int[]{10, 20, 30, 10}));
    }
}
