package dp.medium.subsequence;

import java.util.Arrays;

public class SubsetSumToK {

    //1. Recursion
//    public static boolean subsetSumToK(int n, int k, int arr[]){
//        // Write your code here.
//        return helper(0, 0, n, k, arr);
//    }
//
//    public static boolean helper(int index, int currSum, int n, int k, int[] arr){
//        if(index==n){
//            if(currSum==k) return true;
//            return false;
//        }
//        return helper(index+1, currSum+arr[index], n, k, arr) || helper(index+1, currSum, n, k, arr);
//    }

    //2. Memoization
//    public static boolean subsetSumToK(int n, int k, int[] arr){
//        // Write your code here.
//        int[][] dp = new int[n][k+1];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        return helper(dp, n-1, k, arr);
//    }
//
//    public static boolean helper(int[][] dp, int n, int k, int[] arr){
//        if(k==0) return true;
//        if(n==0) return k==arr[0];
//        if(dp[n][k]!=-1) return dp[n][k] == 1;
//        dp[n][k]= ((arr[n] <= k && helper(dp, n - 1, k - arr[n], arr))|| helper(dp, n-1, k, arr))?1:0;
//        return dp[n][k] == 1;
//    }


//    //3. Tabulation
//    public static boolean subsetSumToK(int n, int k, int arr[]){
//        // Write your code here.
//        boolean[][] dp = new boolean[n][k+1];
//        for(int i=0;i<n;i++) dp[i][0] = true;
//        if(nums[0] <= k) dp[0][arr[0]] = true;
//        for (int i=1; i<n; i++){
//            for(int j=1; j<=k; j++){
//                dp[i][j]= (arr[i] <= j && dp[i-1][j-arr[i]]|| dp[i-1][j]);
//            }
//        }
//        return dp[n-1][k];
//    }

    //4. Space Optimization
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        if(arr[0]<=k) dp[arr[0]] = true;
        for (int i=1; i<n; i++){
            boolean[] temp = new boolean[k+1];
            temp[0] = true;
            for(int j=1; j<=k; j++){
                temp[j]= (arr[i] <= j && dp[j-arr[i]]|| dp[j]);
            }
            dp = temp;
        }
        return dp[k];
    }

    public static void main(String[] args) {
        System.out.println(subsetSumToK(5, 4, new int[]{2, 5, 1, 6, 7}));
    }
}
