package backtracking.medium;

import java.util.Arrays;

public class wordSearch {

    public static boolean exist(char[][] board, String word) {
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[row].length; col++){
                if(board[row][col]==word.charAt(0)){
                    if(helper(word, 0, row, col, board)) return true;
                }
            }
        }
        return false;
    }
    public static boolean helper(String word,int wordIndex, int row,int col,char[][] board) {
        if(wordIndex==word.length()) return true;
        if(row<0 || col<0 || row>=board.length  || col>=board[0].length || board[row][col] != word.charAt(wordIndex) || board[row][col] == '1') return false;
        board[row][col] = '1';
        boolean temp = helper(word, wordIndex+1, row, col - 1, board)
                || helper(word, wordIndex+1, row, col + 1, board)
                || helper(word, wordIndex+1 , row-1, col, board)
                || helper(word, wordIndex+1, row+1, col, board);
        board[row][col] = word.charAt(wordIndex);
        return temp;
    }



    public static boolean exist1(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    System.out.println(i+" "+j);
                    if(helper(board, word, 0, i, j)) return true;;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int index, int row, int col){
        if(index==word.length()) return true;
        if(row<0 || col<0 || row>=board.length  || col>=board[0].length || board[row][col] != word.charAt(index) || board[row][col] == '1') return false;
        board[row][col] = '1';
        boolean temp = helper(word, index+1, row, col - 1, board)
                || helper(word, index+1, row, col + 1, board)
                || helper(word, index+1 , row-1, col, board)
                || helper(word, index+1, row+1, col, board);
        board[row][col] = word.charAt(index);
        return temp;
    }

    public static void main(String[] args) {
        char[][] ipBoard = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String ipString = "ABCCED";

//        String ipString = "SEE";
        String ipString = "ABCB";
        System.out.println(exist1(ipBoard, ipString));
    }
}
