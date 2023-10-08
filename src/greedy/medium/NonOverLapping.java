package greedy.medium;

import java.util.Arrays;

public class NonOverLapping {
    public static int minimumReschedules(int n, int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, (i1, i2)->{
            if(i2[0]<i1[0]) return 1;
            else if(i2[0]==i1[0]) return i1[1]-i2[1];
            else return -1;
        });
        int count = 1;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=intervals[i-1][1]) count++;
        }
        return intervals.length-count;
    }
}
