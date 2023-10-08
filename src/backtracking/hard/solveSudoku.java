package backtracking.hard;

import java.util.Arrays;

public class solveSudoku {

    public static void solveSudoku(char[][] board) {
            helper(board);
        }

    public static boolean helper(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    for(char k='1'; k<= '9'; k++){
                        System.out.println("i "+i+"j "+j+"k "+k);
                        if(canPlace(board, i, j, k)){
                            board[i][j] = k;
                            if(helper(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canPlace(char[][] board, int row, int col, char dig){
        // check row and col
        for(int i=0; i<board.length; i++) {
            if(board[row][i]==dig || board[i][col]==dig) return false;
            if(board[((row/3)*3) + i/3 ][((col/3)*3) + i%3 ] == dig) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] ip = { {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(ip);
        Arrays.stream(ip).forEach(System.out::println);
    }
}
