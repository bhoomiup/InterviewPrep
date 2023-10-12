import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    int time;

    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[] noOfMins = new int[1];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if( grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        BFS(grid, q, noOfMins);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if( grid[i][j]==1) return -1;
            }
        }
        return noOfMins[0];
    }

    public static void BFS(int[][] grid, Queue<Pair> q, int[] maxtime) {
        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        while (!q.isEmpty()){
            Pair node = q.poll();
            maxtime[0] = Math.max(node.time, maxtime[0]);
            grid[node.row][node.col] = 2;
            for(int i = 0; i<4; i++){
                int tempRow = node.row+delRow[i];
                int tempCol = node.col+delCol[i];
                if(tempRow >= 0 && tempCol >= 0 && tempRow < grid.length && tempCol < grid[0].length &&
                        grid[tempRow][tempCol] == 1) {
                    grid[tempRow][tempCol] = 2;
                    q.add(new Pair(tempRow, tempCol, node.time+1));
                }
            }
        }
    }

}