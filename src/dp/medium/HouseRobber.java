package dp.medium;

public class HouseRobber {

    // 1. Recursion
//    public static int rob(int[] nums) {
//        return helper(nums.length-1, nums);
//    }
//
//    public static int helper(int index, int[] nums){
//        if(index<0) return 0;
//        if(index== 0) return nums[0];
//        int pick = helper(index-2, nums)+nums[index];
//        int notPick =  helper(index-1, nums);
//        return Math.max(pick, notPick);
//    }

//    // 2. Memoization
//    public static int rob(int[] nums) {
//        int[] dp= new int[nums.length];
//        return helper(nums.length-1, dp, nums);
//    }
//
//    public static int helper(int index,int[] dp, int[] nums){
//        if(index<0) return 0;
//        if(index== 0) return nums[0];
//        if(dp[index]!=0) return dp[index];
//        int pick = helper(index-2, dp , nums)+nums[index];
//        int notPick =  helper(index-1, dp, nums);
//        return dp[index] = Math.max(pick, notPick);
//    }

//    // 3. Tabulation
//    public static int rob(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        for(int i=1; i<n; i++){
//            int pick = (i-2)>=0?dp[i-2]+nums[i]:nums[i];
//            int notPick = dp[i-1];
//            dp[i] = Math.max(pick, notPick);
//        }
//        return dp[n-1];
//    }

    // 3. Space Optimization
    public static int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev1 = 0;
        for(int i=1; i<n; i++){
            int curr = Math.max(prev1+nums[i], prev);
            prev1 = prev;
            prev = curr;
        }
        return prev;

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
