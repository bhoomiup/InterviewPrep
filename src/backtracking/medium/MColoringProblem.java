package backtracking.medium;

public class MColoringProblem {

    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        if(m==n)return true;
        int[] color_mark = new int[n];
        return helper(graph, color_mark, m, n, 0);
    }

    public static boolean helper(boolean graph[][], int[] color_mark, int m, int n, int curr_node){
        if(curr_node==n) return true;
        for(int color=1; color<=m; color++){
            if(canColor(graph, color, color_mark, curr_node)){
                color_mark[curr_node] = color;
                if(helper(graph, color_mark, m, n, curr_node+1)) return true;
                color_mark[curr_node] = 0;
            }
        }
        return false;
    }

    public static boolean canColor(boolean graph[][], int color, int[] colorMark, int currNode){
        if (currNode==0)return true;
        for (int i=0; i<currNode; i++) {
            if((graph[currNode][i] | graph[i][currNode]) & colorMark[i]==color) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] ip = {{false, true, true},
                            {false, false, true},
                            {false, false, false}};
        System.out.println(graphColoring(ip, 2, ip.length));
//        boolean[][] ip = {{false, true, true, false},
//                            {false, false, true, false},
//                            {false, false, false, true},
//                            {true, false, false, false}};
//        System.out.println(graphColoring(ip, 3, ip.length));
    }
}
