package dp.medium.ThreeD;

import java.util.Arrays;

public class ChocolatePickup {

//    //1. Recursion
//    public static int maximumChocolates(int r, int c, int[][] grid) {
//        // Write your code here.
//        return helper(0, 0, c-1, r, c, grid);
//    }
//
//    public static int helper(int i, int j1, int j2,int r, int c, int[][] grid){
//        if(i>r-1 || j1<0 || j1>c-1 || j2<0 || j2>c-1) return (int)-1e7;
//        if(i==r-1){
//            if(j1==j2) return grid[i][j1];
//            else return grid[i][j1]+grid[i][j2];
//        }
//        int maxi = Integer.MIN_VALUE;
//        for(int x=-1; x<=1; x++){
//            for(int y=-1; y<=1; y++){
//                if(j1==j2) maxi = Math.max(maxi, grid[i][j1]+helper(i+1, j1+x, j2+y, r, c, grid));
//                else  maxi = Math.max(maxi, grid[i][j1]+grid[i][j2]+helper(i+1, j1+x, j2+y, r, c, grid));
//            }
//        }
//        return maxi;
//    }

//    // 2. Memoization
//    public static int maximumChocolates(int r, int c, int[][] grid) {
//        // Write your code here.
//        int[][][] dp = new int[r][c][c];
//        for(int[][] i: dp){
//            for (int[] j: i){
//                Arrays.fill(j, -1);
//            }
//        }
//        return helper(0, 0, c-1, dp, r, c, grid);
//    }
//
//    public static int helper(int i, int j1, int j2, int[][][] dp, int r, int c, int[][] grid){
//        if(i>r-1 || j1<0 || j1>c-1 || j2<0 || j2>c-1) return (int)-1e7;
//        if(i==r-1){
//            if(j1==j2) return grid[i][j1];
//            else return grid[i][j1]+grid[i][j2];
//        }
//        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
//        int maxi = Integer.MIN_VALUE;
//        for(int x=-1; x<=1; x++){
//            for(int y=-1; y<=1; y++){
//                if(j1==j2) maxi = Math.max(maxi, grid[i][j1]+helper(i+1, j1+x, j2+y,dp,  r, c, grid));
//                else  maxi = Math.max(maxi, grid[i][j1]+grid[i][j2]+helper(i+1, j1+x, j2+y, dp, r, c, grid));
//            }
//        }
//        return dp[i][j1][j2] = maxi;
//    }

//    // 3. Tabulation
//    public static int maximumChocolates(int r, int c, int[][] grid) {
//        // Write your code here.
//        int[][][] dp = new int[r][c][c];
//        for(int[][] i: dp){
//            for (int[] j: i){
//                Arrays.fill(j, -1);
//            }
//        }
//
//        for(int j1=0; j1<c;j1++){
//            for (int j2=0; j2<c;j2++){
//                if(j1==j2) dp[r-1][j1][j2] = grid[r-1][j1];
//                else dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
//            }
//        }
//
//        for(int i=r-2; i>=0; i--){
//            for(int j1=0; j1<c;j1++){
//                for (int j2=0; j2<c;j2++){
//                    int maxi =  (int)-1e7;
//                    for(int x=-1; x<=1; x++){
//                        for(int y=-1; y<=1; y++){
//                            int value;
//                            if(j1==j2) value = grid[i][j1];
//                            else value = grid[i][j1]+grid[i][j2];
//                            if(j1+x<0 || j1+x>c-1 || j2+y<0 || j2+y>c-1) value +=(int)-1e7;
//                            else value += dp[i+1][j1+x][j2+y];
//                            maxi = Math.max(maxi, value);
//                        }
//                    }
//                    dp[i][j1][j2] = maxi;
//                }
//            }
//        }
//
//        return dp[0][0][c-1];
//    }

    // 4. Space Optimization
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int[][] dp = new int[c][c];
        for(int[] i: dp)Arrays.fill(i, -1);

        for(int j1=0; j1<c;j1++){
            for (int j2=0; j2<c;j2++){
                if(j1==j2) dp[j1][j2] = grid[r-1][j1];
                else dp[j1][j2] = grid[r-1][j1]+grid[r-1][j2];
            }
        }

        for(int i=r-2; i>=0; i--){
            int[][] temp = new int[c][c];
            for(int j1=0; j1<c;j1++){
                for (int j2=0; j2<c;j2++){
                    int maxi =  (int)-1e7;
                    for(int x=-1; x<=1; x++){
                        for(int y=-1; y<=1; y++){
                            int value;
                            if(j1==j2) value = grid[i][j1];
                            else value = grid[i][j1]+grid[i][j2];
                            if(j1+x<0 || j1+x>c-1 || j2+y<0 || j2+y>c-1) value +=(int)-1e7;
                            else value += dp[j1+x][j2+y];
                            maxi = Math.max(maxi, value);
                        }
                    }
                    temp[j1][j2] = maxi;
                }
            }
            dp = temp;
        }

        return dp[0][c-1];
    }

}
