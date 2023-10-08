package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> op = new ArrayList<>();
        op.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++){
            if(op.get(op.size()-1)[1]>=intervals[i][0]) op.get(op.size()-1)[1] = Math.max(intervals[i][1],
                    op.get(op.size()-1)[1]);
            else op.add(intervals[i]);
        }
        int[][] out = new int[op.size()][];
        for (int i=0; i<op.size(); i++) out[i] = op.get(i);
        return out;
    }

    public static void main(String[] args) {
        int[][] ip = {{1,3},{2,4},{6,8},{9,10}} ;
        System.out.println(merge(ip));
    }
}
