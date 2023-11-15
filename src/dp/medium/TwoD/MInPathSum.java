package dp.medium.TwoD;

import java.util.Arrays;

public class MInPathSum {
//    // 1. Recursion
//    public int minPathSum(int[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//        return helper(m-1, n-1, grid);
//    }
//    public int helper(int m, int n, int[][] grid){
//        if(m<0 || n<0) return (int)1e9;
//        if(m==0 && n==0) return grid[0][0];
//        int left = grid[m][n]+ helper(m-1, n, grid);
//        int right = grid[m][n]+helper(m, n-1, grid);
//        return Math.min(left, right);
//    }
//
//    // 2. Memoization
//    public int minPathSum(int[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//        int[][] dp = new int[m][n];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        return helper(m-1, n-1, dp, grid);
//    }
//    public int helper(int m, int n, int[][] dp, int[][] grid){
//        if(m<0 || n<0) return (int)1e9;
//        if(m==0 && n==0) return grid[0][0];
//        if(dp[m][n]!=-1) return dp[m][n];
//        int left = grid[m][n]+ helper(m-1, n, dp, grid);
//        int right = grid[m][n]+helper(m, n-1, dp, grid);
//        return dp[m][n] = Math.min(left, right);
//    }


//    // 3. Tabulation
//    public int minPathSum(int[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//        int[][] dp = new int[m][n];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        dp[0][0] = grid[0][0];
//        for(int i =0; i<m; i++){
//            for (int j=0;j<n;j++){
//                if(i==0 && j==0) continue;
//                int left = i>0?grid[i][j]+ dp[i-1][j]:(int)1e9;
//                int up = j>0?grid[i][j]+dp[i][j-1]:(int)1e9;
//                dp[i][j] = Math.min(left, up);
//            }
//        }
//        return dp[m-1][n-1];
//    }

    // 4. Space Optimization
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] upRow = new int[n];
        for(int i =0; i<m; i++){
            int[] temp = new int[n];
            for (int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[0] = grid[0][0];
                    continue;
                }
                int left = j>0?grid[i][j]+ temp[j-1]:(int)1e9;
                int up = i>0?grid[i][j]+upRow[j]:(int)1e9;
                temp[j] = Math.min(left, up);
            }
            upRow=temp;
        }
        return upRow[n-1];
    }
}
