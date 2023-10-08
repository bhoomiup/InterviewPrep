package binarySearch;

public class SerachIn2D2 {

//    // method-1
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int currRow = 0;
//        int currCol = matrix[0].length-1;
//        boolean op;
//        while(currRow<matrix.length && currCol>-1){
//            if(matrix[currRow][currCol]==target) return true;
//            else if (matrix[currRow][currCol]>target) {
//                if(rowBinarySearch(matrix, 0, currCol-1, target, currRow)) return true;
//            } else {
//                if (colBinarySearch(matrix, currRow+1, matrix[0].length-1, target, currCol )) return true;
//            }
//            currRow++;
//            currCol--;
//        }
//        return false;
//    }
//
//    public boolean rowBinarySearch(int[][] matrix, int start, int end, int target, int row){
//        int m;
//        while (start<=end){
//            m = (start+end)/2;
//            if(matrix[row][m]==target) return true;
//            else if (matrix[row][m]<target) start=m+1;
//            else end=m-1;
//        }
//        return false;
//    }
//
//    public boolean colBinarySearch(int[][] matrix, int start, int end, int target, int col){
//        int m;
//        while (start<=end){
//            m = (start+end)/2;
//            if(matrix[m][col]==target) return true;
//            else if (matrix[m][col]<target) start=m+1;
//            else end=m-1;
//        }
//        return false;
//    }

}
