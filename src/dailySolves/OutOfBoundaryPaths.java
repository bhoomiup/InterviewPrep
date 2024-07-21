package dailySolves;

public class OutOfBoundaryPaths {
    // https://leetcode.com/problems/out-of-boundary-paths/?envType=daily-question&envId=2024-01-26


    // DP
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return helper(m, n, maxMove, startRow, startColumn);
    }

    public int helper(int m, int n, int maxMove, int row, int col){
        if(row==m || col==n || row<0 || col<0) return 1;
        if(maxMove==0) return 0;
        return helper(m, n, maxMove-1, row-1, col) +
                helper(m, n, maxMove-1, row+1, col) +
                helper(m, n, maxMove-1, row, col+1)+
                helper(m, n, maxMove-1, row, col-1);
    }
}
