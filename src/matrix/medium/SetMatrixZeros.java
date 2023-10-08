package matrix.medium;

import java.util.ArrayList;
import java.util.HashSet;

public class SetMatrixZeros {

    public static void setZeroes(int[][] matrix) {

//        // Better
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[] zeroRows = new int[rows];
//        int[] zeroCols = new int[cols];
//        for(int i=0; i<rows; i++){
//            for(int j=0; j< cols; j++){
//                if(matrix[i][j]==0) {
//                    zeroRows[i]=1;
//                    zeroCols[j]=1;
//                }
//            }
//        }
//
//        for(int i=0; i<rows; i++){
//            for(int j=0; j< cols; j++){
//                if(zeroRows[i]==1 || zeroCols[j]==0) matrix[i][j] = 0;
//            }
//        }
        // Optimal - Constant Space

        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = matrix[0][0];
        for(int i=0; i<rows; i++){
            for(int j=0; j< cols; j++){
                if(matrix[i][j]==0) {
                    matrix[i][0]=1;
                    if(j==0) col0 = 1;
                    else matrix[0][j]=1;
                }
            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j< cols; j++){
                if(matrix[i][0]==1 || matrix[0][j]==1) matrix[i][j] = 0;
            }
        }

        if(matrix[0][0]==1)
        {
            for(int i=0; i< cols; i++) matrix[0][i] = 0;
        }

        if(col0==1)
        {
            for(int i=0; i< rows; i++) matrix[i][0] = 0;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }

}

