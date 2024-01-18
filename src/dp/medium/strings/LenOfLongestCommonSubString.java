package dp.medium.strings;

public class LenOfLongestCommonSubString {
        // Write your code here.


       // 3. Tabulation
//        public static int lcs(String str1, String str2){
//            int m = str1.length(), n = str2.length();
//            int[][] dp = new int[m+1][n+1];
//            int longestLen = 0;
//            for(int i=1; i<m+1; i++){
//                for(int j=1; j<n+1; j++){
//                    if(str1.charAt(i-1)== str2.charAt(j-1)) {
//                        dp[i][j] = 1+dp[i-1][j-1];
//                        longestLen = Math.max(longestLen,  dp[i][j] );
//
//                    }
//                    else dp[i][j]  = 0;
//                }
//            }
//            return longestLen;
//        }

//    // 4. Space Optimization
//    public static int lcs(String str1, String str2){
//        int m = str1.length(), n = str2.length();
//        int[] prev = new int[n+1];
//        int[] curr;
//        int longestLen = 0;
//        for(int i=1; i<m+1; i++){
//            curr = new int[n+1];
//            for(int j=1; j<n+1; j++){
//                if(str1.charAt(i-1)== str2.charAt(j-1)){
//                    curr[j] = 1+prev[j-1];
//                    longestLen = Math.max(longestLen,  curr[j] );
//                }
//                else curr[j]  = 0;
//            }
//            prev = curr;
//        }
//        return longestLen;
//    }

}

