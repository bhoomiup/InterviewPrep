package dp.medium.TwoD;

import java.util.List;

public class MinPathSumTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size()-1;
        int n = triangle.get(m).size()-1;
        int[] op = new int[1];
        op[0] = Integer.MAX_VALUE;
        helper(0, 0, m, n, 0, op, triangle);
        return op[0];
    }

    public void helper(int currRow, int currCol, int m, int n, int currSum, int[] op,  List<List<Integer>> triangle){
        if(currRow>m || currCol>triangle.get(m).size()-1) return;
        if(currRow==m){
            op[0] = Math.min(currSum+triangle.get(currRow).get(currCol), op[0]);
            return;
        }
        helper(currRow+1, currCol, m, n, currSum+triangle.get(currRow).get(currCol), op, triangle );
        helper(currRow+1, currCol+1, m, n, currSum+triangle.get(currRow).get(currCol), op, triangle );
    }
}
