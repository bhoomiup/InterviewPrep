package dp.medium.TwoD;

public class UniquePaths {

//    //1. Recursion
//    public int uniquePaths(int m, int n) {
//        int[] op = new int[1];
//        helper(m-1, n-1, op);
//        return op[0];
//    }
//    public void helper(int m, int n, int[]op){
//        if(m<0 || n<0) return;
//        if(m==0 && n==0){
//            op[0]+=1;
//            return;
//        }
//
//        helper(m-1, n,  op);
//        helper(m, n-1, op);
//    }

    //2. Memoization
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        return helper(m-1, n-1, dp);
//    }
//    public int helper(int m, int n, int[][] dp){
//        if(m<0 || n<0) return 0;
//        if(m==0 && n==0) return 1;
//        if(dp[m][n]!=0) return dp[m][n];
//        int left = helper(m-1, n, dp);
//        int up = helper(m, n-1, dp);
//        return  dp[m][n]=left+up;
//    }

//    // 3. Tabulation
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        dp[0][0] = 1;
//        for(int i=0; i<m;i++){
//            for (int j=0; j<n; j++){
//                if(i==0 && j==0) continue;
//                int left = i-1>=0?dp[i-1][j]:0;
//                int up = j-1>=0?dp[i][j-1]:0;
//                dp[i][j]=left+up;
//            }
//
//        }
//        return dp[m-1][n-1];
//    }

    //4. Space Optimization
    public static int uniquePaths(int m, int n) {
        int[] upRow = new int[n];
        for(int i=0; i<m;i++){
            int[] temp = new int[n];
            for (int j=0; j<n; j++){
                if(i==0 && j==0) {
                    temp[i] = 1;
                    continue;
                };
                int leftValue = j>0?temp[j-1]:0;
                temp[j]=upRow[j]+leftValue;
            }
            upRow=temp;
        }
        return upRow[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));

    }
}
