package graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair5{
    int row;
    int col;
    int distance;
    Pair5(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        if(n==1&&m==1 && grid[n-1][m-1]==0) return 1;

        int[][] dist = new int[n][m];
        for (int[] i: dist) Arrays.fill(i, (int)1e9);
        dist[0][0] = 1;
        Queue<Pair5> q = new LinkedList<>();
        q.add(new Pair5(0, 0, 1));

        while (!q.isEmpty()){
            Pair5 p = q.poll();
            int row = p.row;
            int col = p.col;
            int distance = p.distance;
            for (int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i==0 && j==0) continue;
                    int newRow = row+i;
                    int newCol = col+j;
                    if(newRow>=0 && newRow<=n-1 && newCol>=0 && newCol<=m-1 && grid[newRow][newCol]==0
                            && distance+1<dist[newRow][newCol]){
                        dist[newRow][newCol] = distance+1;
                        if(newRow==n-1 && newCol==m-1) return distance+1;
                        q.add(new Pair5(newRow, newCol, distance+1 ));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }
}
