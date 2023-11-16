package dp.medium.TwoD;

import java.util.Arrays;

public class MinFallinPathSum {
//    // 1. Recursiom
//    public int minFallingPathSum(int[][] matrix) {
//        int n=matrix.length;
//        int op= Integer.MAX_VALUE;
//        for(int i=0; i<n; i++){
//            op = Math.min(op, helper(0, i, n-1, matrix));
//        }
//        return op;
//    }
//
//    public int helper(int row, int col, int n, int[][] matrix){
//        if(row>n || col>n || col<0) return (int) 1e9;
//        if(row==n) return matrix[row][col];
//        int leftDia = matrix[row][col]+helper(row+1, col-1, n, matrix);
//        int down = matrix[row][col]+helper(row+1, col, n, matrix);
//        int rightDia = matrix[row][col]+helper(row+1, col+1, n, matrix);
//        int temp = Math.min(leftDia, down);
//        return  Math.min(temp, rightDia);
//    }

    //2. Memoization
//    public int minFallingPathSum(int[][] matrix) {
//        int n=matrix.length;
//        int op= Integer.MAX_VALUE;
//        int[][] dp = new int[n][n];
//        for (int[] i:dp) Arrays.fill(i, (int) 1e9);
//        for(int i=0; i<n; i++){
//            op = Math.min(op, helper(0, i, n-1, dp, matrix));
//        }
//        return op;
//    }
//
//    public int helper(int row, int col, int n, int[][] dp, int[][] matrix){
//        if(row>n || col>n || col<0) return (int) 1e9;
//        if(row==n) return matrix[row][col];
//        if(dp[row][col]!=(int) 1e9) return dp[row][col];
//        int leftDia = matrix[row][col]+helper(row+1, col-1, n, dp, matrix);
//        int down = matrix[row][col]+helper(row+1, col, n, dp, matrix);
//        int rightDia = matrix[row][col]+helper(row+1, col+1, n, dp, matrix);
//        int temp = Math.min(leftDia, down);
//        return  dp[row][col]=Math.min(temp, rightDia);
//    }

//    //3. Tabulation
//    public static int minFallingPathSum(int[][] matrix) {
//        int n=matrix.length;
//        int[][] dp = new int[n][n];
//        for (int[] i:dp) Arrays.fill(i, (int) 1e9);
//        for(int i=0;i<n;i++) dp[n-1][i] = matrix[n-1][i];
//        for(int i=n-2; i>=0; i--){
//            for(int j=0; j<matrix[i].length; j++){
//                int nextleftDia = j>0?dp[i+1][j-1]:(int)1e9;
//                int leftDia = matrix[i][j]+nextleftDia;
//
//                int down = matrix[i][j]+dp[i+1][j];
//
//                int nextRightDia = j<n-1?dp[i+1][j+1]:(int)1e9;
//                int rightDia = matrix[i][j]+nextRightDia;
//
//                int temp = Math.min(leftDia, down);
//                dp[i][j]=Math.min(temp, rightDia);
//            }
//        }
//        int op= dp[0][0];
//        for(int i: dp[0]) op= Math.min(op, i);
//        return op;
//    }

    //4. Space-Optimization
    public static int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = matrix[n-1][i];
        for(int i=n-2; i>=0; i--){
            int[] temp = new int[n];
            for(int j=0; j<matrix[i].length; j++){
                int nextleftDia = j>0?dp[j-1]:(int)1e9;
                int leftDia = matrix[i][j]+nextleftDia;

                int down = matrix[i][j]+dp[j];

                int nextRightDia = j<n-1?dp[j+1]:(int)1e9;
                int rightDia = matrix[i][j]+nextRightDia;

                int tempMin = Math.min(leftDia, down);
                temp[j]=Math.min(tempMin, rightDia);
            }
            dp=temp;
        }
        int op= dp[0];
        for(int i: dp) op= Math.min(op, i);
        return op;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));

    }
}
