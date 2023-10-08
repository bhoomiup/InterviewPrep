package matrix.medium;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=i+1; j< cols; j++){
                if(i!=j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int row=0; row<rows; row++){
            int l = 0;
            int r = cols-1;
            while (l<r){
                int temp = matrix[row][l];
                matrix[row][l] = matrix[row][r];
                matrix[row][r] = temp;
                l++;
                r--;
            }
        }
    }
}
