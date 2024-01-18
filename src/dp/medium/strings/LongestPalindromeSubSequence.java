package dp.medium.strings;

import java.util.Arrays;

public class LongestPalindromeSubSequence {


//    // 1. Recursion
//
//    public int longestPalindromeSubseq(String s) {
//        return longestCommonSubsequence(s, new StringBuilder().append(s).reverse().toString());
//    }
//    public static int longestCommonSubsequence(String text1, String text2) {
//        return helper(text1, text2, text1.length()-1, text2.length()-1);
//    }
//
//    public static int helper(String text1, String text2, int index1, int index2){
//        if(index1<0 || index2<0) return 0;
//        if(text1.charAt(index1)== text2.charAt(index2)) return 1+helper(text1, text2, index1-1, index2-1);
//        return Math.max(helper(text1, text2, index1-1, index2), helper(text1, text2, index1, index2-1));
//    }

//    // 2. Memoization

//    public int longestPalindromeSubseq(String s) {
//        return longestCommonSubsequence(s, new StringBuilder().append(s).reverse().toString());
//    }
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length(), n = text2.length();
//        int[][] dp = new int[m][n];
//        for(int[] i: dp) Arrays.fill(i, -1);
//        return helper(text1, text2, m-1, n-1, dp);
//    }
//
//    public static int helper(String text1, String text2, int index1, int index2, int[][] dp){
//        if(index1<0 || index2<0) return 0;
//        if(dp[index1][index2]!=-1) return dp[index1][index2];
//        if(text1.charAt(index1)== text2.charAt(index2))
//            return dp[index1][index2] = 1+helper(text1, text2, index1-1, index2-1, dp);
//        return dp[index1][index2]  =  Math.max(helper(text1, text2, index1-1, index2, dp),
//                helper(text1, text2, index1, index2-1, dp));
//    }


//

//    // 4. Tabulation
//    public int longestPalindromeSubseq(String s) {
//        return longestCommonSubsequence(s, new StringBuilder().append(s).reverse().toString());
//    }
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length(), n = text2.length();
//        int[][] dp = new int[m+1][n+1];
//        for(int i=1; i<m+1; i++){
//            for(int j=1; j<n+1; j++){
//                if(text1.charAt(i-1)== text2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
//                else dp[i][j]  =  Math.max(dp[i-1][j], dp[i][j-1]);
//            }
//        }
//        return dp[m][n];
//    }

    // 5. Space Optimization

    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder().append(s).reverse().toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n+1];
        int[] curr;
        for(int i=1; i<m+1; i++){
            curr = new int[n+1];
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)) curr[j] = 1+prev[j-1];
                else curr[j]  =  Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }

}
