package array.medium;

import java.util.Arrays;

public class MaxPointsObtainFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        int totalSum = Arrays.stream(cardPoints).sum();
        int n = cardPoints.length;
        if (k==n) return totalSum;
        int i = 0, j = 0, sum = 0, max_sum = 0;
        while (j<cardPoints.length){
            if(n-(j-i+1)>=k){
                sum += cardPoints[j];
                if(n-(j-i+1)==k){
                    max_sum = Math.max(max_sum, totalSum-sum);
                    sum -= cardPoints[i];
                    i++;
                }
            }
            j ++;
        }
        return max_sum;
    }

    public static void main(String[] args) {
//        int [] cardPoints = {1,2,3,4,5,6,1};
//        int k = 3;
//        int [] cardPoints = {2,2,2};
//        int k = 2;
        int [] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        System.out.println(maxScore(cardPoints, k));
    }
}
