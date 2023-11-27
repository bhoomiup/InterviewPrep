package dp.medium.subsequence;

import java.util.Arrays;

public class PartitionEqualSubSetSum {

//    //1. Recursion
//    public static boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if(sum%2==1) return false;
//        return helper(nums.length-1, sum/2, nums);
//    }
//
//    public static boolean helper(int n, int k, int[] arr){
//        if(k==0) return true;
//        if(n<0) return false;
//        return helper(n-1, k-arr[n], arr) || helper(n-1, k, arr);
//    }

//    //2. Memoization
//    public static boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        int n = nums.length;
//        if(sum%2==1) return false;
//        int[][] dp = new int[n][(sum/2)+1];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        return helper(n-1, sum/2, dp, nums);
//    }
//
//    public static boolean helper(int n, int k, int[][] dp, int[] arr){
//        if(k==0) return true;
//        if(n==0) return k==arr[0];
//        if(dp[n][k]!=-1) return dp[n][k]==1;
//        dp[n][k] = (arr[n]<=k && helper(n-1, k-arr[n], dp, arr) || helper(n-1, k, dp, arr))?1:0;
//        return dp[n][k]==1;
//    }
//
//    //3. Tabulation
//    public static boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        int n = nums.length;
//        int equalSum = sum/2;
//        if(sum%2==1) return false;
//        boolean[][] dp = new boolean[n][equalSum+1];
//        for(int i=0; i<n; i++) dp[i][0] = true;
//        if(nums[0] <= equalSum) dp[0][nums[0]]=true;
//        for (int i=1; i<n; i++){
//            for(int j=1; j<=equalSum; j++){
//                dp[i][j]= (nums[i] <= j && dp[i-1][j-nums[i]]|| dp[i-1][j]);
//            }
//        }
//        return dp[n-1][equalSum];
//    }

    // 4. Space Optimization
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int equalSum = sum/2;
        if(sum%2==1) return false;
        boolean[] dp = new boolean[equalSum+1];
        dp[0] = true;
        if(nums[0] <= equalSum) dp[nums[0]]=true;
        for (int i=1; i<n; i++){
            boolean[] temp = new boolean[equalSum+1];
            for(int j=1; j<=equalSum; j++){
                temp[j]= (nums[i] <= j && dp[j-nums[i]]|| dp[j]);
            }
            dp=temp;
        }
        return dp[equalSum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }
}
