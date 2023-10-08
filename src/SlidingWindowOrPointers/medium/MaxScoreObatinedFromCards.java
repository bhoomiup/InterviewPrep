package SlidingWindowOrPointers.medium;

import java.util.Arrays;

public class MaxScoreObatinedFromCards {
    public int maxScore(int[] cardPoints, int k) {
        if(k==cardPoints.length) return Arrays.stream(cardPoints).sum();
        int i = 0;
        int j = 0;
        int n = cardPoints.length;
        int elesToRemove = n-k;
        int currSum = 0;
        int minSum = Integer.MAX_VALUE;
        while(j<n){
            currSum+=cardPoints[j];
            if((j-i+1) == elesToRemove) {
                minSum = Math.min(minSum, currSum);
                currSum-=cardPoints[i];
                i++;
            }
            j++;
        }
        int totalSum = Arrays.stream(cardPoints).sum();
        return totalSum-minSum;
    }
}
