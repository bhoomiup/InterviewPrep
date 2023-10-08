package binarySearch;

public class SearchIn2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0;
        int rowHigh = matrix.length;
        int rowMid;
        while (rowLow<=rowHigh){
            rowMid = (rowLow+rowHigh)/2;
            if(target>=matrix[rowMid][0] && target<=matrix[rowMid][matrix[0].length]){
                int l=0;
                int h=matrix[0].length;
                int m;
                while (l<=h){
                    m = (l+h)/2;
                    if(matrix[rowMid][m]==target) return true;
                    else if (matrix[rowMid][m]<target) l=m+1;
                    else h=m-1;
                }
                return false;
            }
            else if (target<matrix[rowMid][0]) rowHigh = rowMid-1;
            else rowLow = rowMid+1;
        }
        return false;
    }
}
