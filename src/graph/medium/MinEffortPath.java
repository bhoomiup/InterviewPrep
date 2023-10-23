package graph.medium;

import java.util.*;

public class MinEffortPath {
    static class Pair5{
        int row;
        int col;
        int diff;
        Pair5(int row, int col, int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair5> q = new PriorityQueue<>(Comparator.comparingInt(x-> x.diff));
        q.add(new Pair5(0, 0, 0));

        int[][] diff = new int[n][m];
        for (int[] i: diff) Arrays.fill(i, (int)1e9);
        diff[0][0] = 0;

        int[] delRow = {0, 0, -1, 1};
        int[] delCol = {-1, 1, 0, 0};

        while (!q.isEmpty()){
            Pair5 p = q.poll();
            int row = p.row;
            int col = p.col;
            int currDiff = p.diff;
            if(row==n-1 && col==m-1) return currDiff;
            for (int i=0; i<4; i++){
                int newRow = row+delRow[i];
                int newCol = col+delCol[i];
                if(newRow>=0 && newRow<=n-1 && newCol>=0 && newCol<=m-1){
                    int newDiff = Math.max(Math.abs(heights[newRow][newCol]-heights[row][col]), currDiff);
                    if(newDiff<diff[newRow][newCol]){
                        q.add(new Pair5(newRow, newCol, newDiff));
                        diff[newRow][newCol] = newDiff;
                    }

                }

            }
        }
        return -1;
    }
}
