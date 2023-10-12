package graph.medium;

import java.util.LinkedList;
import java.util.Queue;



public class NearestZero {
    static class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] op = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if (mat[i][j]==1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        int[] delRow = {0, 0, 1, -1};
        int[] delCol = {1, -1, 0, 1};
        BFS( mat, visited, op, q, delRow, delCol);
        return op;

    }

    public static void BFS(int[][] mat, int[][] visited, int[][] op, Queue<Pair> q, int[] delRow, int[] delCol){
        while (!q.isEmpty()){
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int dist = node.dist;
            op[row][col] = dist;
            for (int i=0; i<4; i++){
                int currRow = row+delRow[i];
                int currCol = col+delCol[i];
                if(currRow>=0 && currCol >=0 && currRow<mat.length && currCol<mat[0].length && visited[currRow][currCol]!=1){
                    visited[currRow][currCol] = 1;
                    q.add(new Pair(currRow, currCol, dist+1));
                }
            }
        }
    }
}
