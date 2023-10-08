package matrix.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> op = new ArrayList<>();
        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length-1;
        while (l<=r & t<=b){
            for (int i=l; i<=r; i++) op.add(matrix[t][i]);
            t++;
            for (int i=t; i<=b; i++) op.add(matrix[i][r]);
            r--;
            if(t<=b)for (int i=r; i>l-1; i--) op.add(matrix[b][i]);
            b--;
            if(l<=r)for (int i=b; i>t-1; i--) op.add(matrix[i][l]);
            l++;
        }
        return op;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix));
    }
}
