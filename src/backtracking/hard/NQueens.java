package backtracking.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> op = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] toLeft = new boolean[n];
        boolean[] upperDiagonal = new boolean[2*n-1];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        helper(board, 0, toLeft, upperDiagonal, lowerDiagonal, op);
        return op;
    }

    // Method 1: using extra method to iterate and check previous rows and columns
//    public static void helper(char[][] board, int col, List<List<String>> op){
//        if(col==board.length){
//            op.add(prepareBoardOp(board));
//            return;
//        }
//        for(int i=0; i< board.length; i++){
//            boolean temp = fill(board, col, i);
//            if(temp){
//                board[i][col] = 'Q';
//                helper(board, col+1, op);
//                board[i][col] = '.';
//            }
//        }
//    }

    // Method 2: using hashing check previous rows and columns

    public static void helper(char[][] board, int col, boolean[] toLeft, boolean[] upperDiagonal,
                              boolean[] lowerDiagonal, List<List<String>> op){
        if(col==board.length){
            op.add(prepareBoardOp(board));
            return;
        }
        for(int row=0; row< board.length; row++){

            if(!toLeft[row]&& !upperDiagonal[board.length-1-(row-col)] && !lowerDiagonal[row+col]){
                toLeft[row] =  true;
                upperDiagonal[board.length-1-(row-col)] =  true;
                lowerDiagonal[(row+col)]  =  true;
                board[row][col] = 'Q';
                helper(board, col+1, toLeft, upperDiagonal, lowerDiagonal, op);
                board[row][col] = '.';
                toLeft[row] =  false;
                upperDiagonal[board.length-1-(row-col)] =  false;
                lowerDiagonal[(row+col)]  =  false;
            }
        }
    }

    public static boolean fill(char[][] board, int col, int row){
        int tempCol = col;
        int tempRow = row;
        while (row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        col = tempCol;
        while (col>=0){
            if(board[tempRow][col]=='Q') return false;
            col--;
        }
        col = tempCol;
        row = tempRow;
        while (row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }

    public static List<String> prepareBoardOp(char[][] board){
        List<String> opBoard = new ArrayList<>();
        for (char[] row : board) {
            String s = new String(row);
            opBoard.add(s);
        }
        return opBoard;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<String> prepareBoardOp( List<List<String>>  board){
        List<String> opBoard = new ArrayList<>();
        for (List<String> row : board) {
            String s = String.join("", row);
            opBoard.add(s);
        }
        return opBoard;
    }
}
