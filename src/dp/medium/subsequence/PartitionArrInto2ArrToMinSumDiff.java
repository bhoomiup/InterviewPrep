package dp.medium.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrInto2ArrToMinSumDiff {
    public int minimumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]]=true;
        for (int i=1; i<n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j]= (nums[i] <= j && dp[i-1][j-nums[i]]|| dp[i-1][j]);
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<=sum;i++){
            if(dp[n-1][i]) minDiff = Math.min(minDiff, Math.abs((sum-i)-i));
        }
        return minDiff;

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> op = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                if(words[i].charAt(j)==x) op.add(i);
                // break;
            }
        }
        return op;
    }
}
