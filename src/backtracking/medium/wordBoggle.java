package backtracking.medium;

import java.util.*;

public class wordBoggle {

    public static String[] wordBoggle(char[][] board, String[] dictionary)
    {
        // Write your code here

        HashSet<String> op = new HashSet<>();
        for(String str: dictionary) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == str.charAt(0)) {
                        char[][] temp_board = new char[board.length][];
                        for (int r = 0; r < board.length; r++)
                            temp_board[r] = board[r].clone();
                        if (helper(temp_board, str, row, col, 0)) {
                            op.add(str);
                            break;
                        }
                    }
                }
            }
        }
        String[] finalOp = new String[op.size()];
        int i=0;
        // iterating over the hashset
        for(String str:op){
            finalOp[i++] = str;
        }
        return finalOp;
    }

    public static boolean helper(char[][] board, String str, int row, int col, int index){
        if(index==str.length()) return true;
        if(row< 0  || col<0 || row >board.length-1 || col > board[0].length-1 ||
                board[row][col]=='1' || board[row][col] != str.charAt(index)) return false;
        board[row][col] = '1';
        int[] dprow = {-1, 0, 1};
        int[] dpcol = {-1, 0, 1};
        for(int i: dprow){
            for(int j: dpcol){
                if (helper(board, str, row+i, col+j, index+1)) return true;
            }
        }
        board[row][col] = str.charAt(index);
        return false;
    }



    public static void main(String[] args) {
//        char[][] board = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
//        String[] dictionary = {"GEEKS","FOR","QUIZ","GO"};
//        System.out.println(Arrays.stream(wordBoggle(board, dictionary)).toList());
//        char[][] board = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};
//        String[] dictionary = {"CAT"};
//        System.out.println(Arrays.stream(wordBoggle(board, dictionary)).toList());
        char[][] board = {
                {'f','f'},
                {'d','e'},
                {'f','b'},
                {'b','e'}};
        String[] dictionary = {"df", "dec", "dfd",  "fd", "ded", "e"};
        System.out.println(Arrays.stream(wordBoggle(board, dictionary)).toList());
    }
}
