package backtracking.medium;

import java.util.ArrayList;

public class ratInMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> op = new ArrayList<>();
        helper(m, 0, 0, "", op);
        return op;
    }

    public static void helper(int[][] maze, int row, int col, String op, ArrayList<String> final_op){
        if(row==maze.length-1 && col== maze.length-1 && maze[row][col]==1){
            final_op.add((op));
            return;
        }
        if(row<0 || col<0||row >= maze.length || col >= maze[0].length || maze[row][col] != 1) return;

        maze[row][col] = -1;
        // move down
        helper(maze, row+1, col, op+"D", final_op);
        // move left
        helper(maze, row, col-1, op+"L", final_op);
        // move right
        helper(maze, row, col+1, op+"R", final_op);
        // move up
        helper(maze, row-1, col, op+"U", final_op);
        maze[row][col] = 1;
    }

    public static void main(String[] args) {
//        int[][] ip = {{1, 0, 0, 0},
//                        {1, 1, 0, 1},
//                        {1, 1, 0, 0},
//                        {0, 1, 1, 1}};
        int[][] ip = {{1, 0},
                    {1, 0}};
        System.out.println(findPath(ip, ip.length));
    }
}
