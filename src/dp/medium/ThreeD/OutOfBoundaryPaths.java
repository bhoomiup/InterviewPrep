package dp.medium.ThreeD;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    // https://leetcode.com/problems/out-of-boundary-paths/?envType=daily-question&envId=2024-01-26


//    // 1. Recursion
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        return helper(m, n, maxMove, startRow, startColumn);
//    }
//
//    public int helper(int m, int n, int maxMove, int row, int col){
//        if(row==m || col==n || row<0 || col<0) return 1;
//        if(maxMove==0) return 0;
//        return helper(m, n, maxMove-1, row-1, col) +
//                helper(m, n, maxMove-1, row+1, col) +
//                helper(m, n, maxMove-1, row, col+1)+
//                helper(m, n, maxMove-1, row, col-1);
//    }

//    // 2. Memoization
//    int mod = (int)1e9 + 7;
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        int[][][] dp = new int[m][n][maxMove];
//        for(int[][] i: dp){
//            for(int[] j: i){
//                Arrays.fill(j, -1);
//            }
//        }
//        return helper(m, n, maxMove-1, startRow, startColumn, dp);
//    }
//
//    public int helper(int m, int n, int maxMove, int row, int col, int[][][] dp){
//        if(row==m || col==n || row<0 || col<0) return 1;
//        if(maxMove<0) return 0;
//        if(dp[row][col][maxMove]!=-1) return dp[row][col][maxMove];
//        return dp[row][col][maxMove] = (helper(m, n, maxMove-1, row-1, col, dp) +
//                helper(m, n, maxMove-1, row+1, col, dp) +
//                helper(m, n, maxMove-1, row, col+1, dp)+
//                helper(m, n, maxMove-1, row, col-1, dp))%(mod);
//    }

//    // 3. Tabulation
//    int mod = (int)1e9 + 7;
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        long[][][] dp = new long[m][n][maxMove+1];
//        long up, down, left, right;
//        for(int k=1; k<=maxMove; k++){
//            for(int i=0; i<m; i++){
//                for(int j=0;j<n; j++){
//                    up = i-1>=0?(dp[i-1][j][k-1])%(mod):1;
//                    down = i+1<m?(dp[i+1][j][k-1])%(mod):1;
//                    left = j-1>=0?(dp[i][j-1][k-1])%(mod):1;
//                    right = j+1<n?(dp[i][j+1][k-1])%(mod):1;
//                    dp[i][j][k] = (up+down+left+right)%(mod);
//                }
//            }
//        }
//
//        return (int)dp[startRow][startColumn][maxMove];
//    }

    // 4. Space Optimization
    int mod = (int)1e9 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][] prev = new long[m][n];
        long up, down, left, right;
        for(int k=1; k<=maxMove; k++){
            long[][] curr = new long[m][n];
            for(int i=0; i<m; i++){
                for(int j=0;j<n; j++){
                    up = i-1>=0?(prev[i-1][j])%(mod):1;
                    down = i+1<m?(prev[i+1][j])%(mod):1;
                    left = j-1>=0?(prev[i][j-1])%(mod):1;
                    right = j+1<n?(prev[i][j+1])%(mod):1;
                    curr[i][j] = (up+down+left+right)%(mod);
                }
                prev = curr;
            }
        }

        return (int)prev[startRow][startColumn];
    }
}
