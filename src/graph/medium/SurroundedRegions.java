package graph.medium;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];

        // row boundary
        for (int j =0; j<board[0].length; j++){
            if(board[0][j]=='O'){
                DFS1(board, visited, 0, j);
            }

            if(board[board.length-1][j]=='O'){
                DFS1(board, visited, board.length-1, j);
            }
        }
        // col boundary
        for (int j =0; j<board.length; j++){
            if(board[j][0]=='O'){
                DFS1(board, visited, j, 0);
            }

            if(board[j][board[0].length-1]=='O'){
                DFS1(board, visited, j, board[0].length-1);
            }
        }

        for (int i= 0; i<board.length; i++){
            for (int j =0; j<board[0].length; j++){
                if(board[i][j]=='O' && visited[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void DFS1(char[][] board, int[][] visited, int row, int col){
        if(row<0 || col<0 || row>board.length-1 || col>board[0].length-1 || visited[row][col]==1 || board[row][col]=='X') return;
        visited[row][col] = 1;
        DFS1(board, visited,  row, col-1);
        DFS1(board, visited, row-1, col);
        DFS1(board, visited, row, col+1);
        DFS1(board, visited, row+1, col);
    }
}
