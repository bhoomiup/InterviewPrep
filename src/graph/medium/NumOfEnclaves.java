package graph.medium;

public class NumOfEnclaves {
    public int numEnclaves(int[][] grid) {
        for (int i=0; i< grid[0].length; i++){
            if(grid[0][i]==1) DFS(grid, 0, i);
            if(grid[grid.length-1][i]==1) DFS(grid, grid.length-1, i);
        }

        for (int i=0; i< grid.length; i++){
            if(grid[i][0]==1) DFS(grid, i, 0);
            if(grid[i][grid[0].length-1]==1) DFS(grid, i, grid[0].length-1);
        }

        int op =0;
        for (int i= 0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if(grid[i][j]==1 || grid[i][j]==-1) op++;
            }
        }
        return op;
    }

    public static void DFS(int[][] board, int row, int col){
        if(row<0 || col<0 || row>board.length-1 || col>board[0].length-1 || board[row][col]!=1) return;
        board[row][col] = -1;
        DFS(board, row, col-1);
        DFS(board, row-1, col);
        DFS(board, row, col+1);
        DFS(board, row+1, col);
    }
}
