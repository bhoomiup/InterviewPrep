package greedy.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> op = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                op.add(newInterval);
                newInterval = interval;
            } else if (newInterval[0] > interval[1]) {
                op.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        op.add(newInterval);
        return op.toArray(new int[op.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ip = new int[][] {{1,3}, {6,9}};
        int[] newI = new int[] {2, 5};
        System.out.println(insert(ip , newI));
    }
}
