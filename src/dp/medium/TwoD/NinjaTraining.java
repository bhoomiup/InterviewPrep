package dp.medium.TwoD;

import java.util.Arrays;

public class NinjaTraining {

    // 1. Recursion
//    public static int ninjaTraining(int n, int points[][]) {
//
//        // Write your code here..
//        return helper(points, n-1, 3);
//    }
//
//    public static int helper(int[][] points, int index, int lastActivity){
//        if(index==0){
//            int max = 0;
//            for (int i=0; i<=2; i++){
//                if(i!=lastActivity) max = Math.max(max, points[0][i]);
//            }
//            return max;
//        }
//        int max = 0;
//        for (int i=0; i<=2; i++){
//            if(i!=lastActivity){
//                int temp = helper(points, index-1, i) + points[index][i];
//                max = Math.max(max, temp);
//            }
//        }
//        return max;
//    }

//    // 2. Memoization
//    public static int ninjaTraining(int n, int points[][]) {
//
//        // Write your code here..
//        int[][] dp = new int[n][4];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        return helper(points, n-1, 3, dp);
//    }
//
//    public static int helper(int[][] points, int index, int lastActivity, int[][] dp){
//        if(index==0){
//            int max = 0;
//            for (int i=0; i<=2; i++){
//                if(i!=lastActivity) max = Math.max(max, points[0][i]);
//            }
//            return max;
//        }
//        if(dp[index][lastActivity]!=-1) return dp[index][lastActivity];
//        int max = 0;
//        for (int i=0; i<=2; i++){
//            if(i!=lastActivity){
//                int temp = helper(points, index-1, i, dp) + points[index][i];
//                max = Math.max(max, temp);
//            }        }
//        return max;
//    }

    // 3. Tabulation
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[]dp = new int[4];
        Arrays.fill(dp, -1);
        for (int i=0; i<=3; i++){
            int max = 0;
            for (int j=0; j<=2; j++){
                if(j!=i) max = Math.max(max, points[0][j]);
            }
            dp[i]=max;
        }
        for(int day=1; day<n; day++){
            int[] temp = new int[4];
            for(int lastActivity=0; lastActivity<=3; lastActivity++ ){
                temp[lastActivity] = 0;
                for (int i=0; i<=2; i++){
                    if(i!=lastActivity){
                        temp[lastActivity] = Math.max(temp[lastActivity], dp[i] + points[day][i]);
                    }
                }
            }
            dp =temp;
        }
        return dp[3];
    }

    public static void main(String[] args) {
        System.out.println(ninjaTraining(3, new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}}));
    }
}
