package graph.medium;

public class NoOfIslands {
    public static int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if( grid[i][j]=='1'){
                    DFS(grid,  i, j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    public static void DFS(char[][] grid, int row, int col){
        if(row<0 || col<0 || row>grid.length-1 || col>grid[row].length-1 || grid[row][col]=='0') return ;
        grid[row][col] = '0';
        DFS(grid,  row, col-1);
        DFS(grid, row-1, col);
        DFS(grid,  row, col+1);
        DFS(grid,row+1, col);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
