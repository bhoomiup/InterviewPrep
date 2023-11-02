package graph.medium;

import graph.basic.Disjoint;

public class NoOfIslandsii {
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        // Write your code here.
        int[][] visited = new int[n][m];
        Disjoint ds = new Disjoint(n*m);
        int[] op = new int[q];
        int count = 0;
        int[] delRow = new int[]{0, 0, -1, +1};
        int[] delCol = new int[]{+1, -1, 0, 0};
        for(int j=0; j<queries.length; j++){
            int currRow = queries[j][0];
            int currCol = queries[j][1];
            if(visited[currRow][currCol]==1){
                op[j] = count;
                continue;
            }
            visited[currRow][currCol] = 1;
            count++;
            for(int i=0; i<4; i++){
                int adjRow = currRow+delRow[i];
                int adjCol = currCol+delCol[i];
                if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<m && visited[adjRow][adjCol]==1){
                    int currNodeNo = currRow*m+currCol;
                    int adjNodeNo = adjRow*m+adjCol;
                    if( ds.findPar(currNodeNo)!=ds.findPar(adjNodeNo)) {
                        ds.unionBySize(currNodeNo, adjNodeNo);
                        count--;
                    }
                }
            }
            op[j] = count;
        }
        return op;
    }
}
