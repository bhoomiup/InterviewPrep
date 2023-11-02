package graph.hard;

import graph.basic.Disjoint;

import java.util.HashSet;
import java.util.Set;

public class MakingLargestIsland {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n*n);
        int[] delRow = new int[]{0, 0, -1, 1};
        int[] delCol = new int[]{1, -1, 0, 0};
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    for(int k=0; k<4; k++){
                        int adjRow = i+delRow[k];
                        int adjCol = j+delCol[k];
                        if(adjRow>=0 && adjCol>=0 && adjRow<n && adjCol<n && grid[adjRow][adjCol]==1){
                            ds.unionBySize(i*n+j, adjRow*n+adjCol);
                        }
                    }

                }
            }
        }
        int maxIslandsOp = 0;
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> s = new HashSet<>();
                    int maxIslands = 0;
                    for(int k=0; k<4; k++){
                        int adjRow = i+delRow[k];
                        int adjCol = j+delCol[k];
                        int adjNodeNo = adjRow*n+adjCol;
                        if(adjRow>=0 && adjCol>=0 && adjRow<n && adjCol<n && grid[adjRow][adjCol]==1 && !s.contains(ds.findPar(adjNodeNo))){
                            s.add(ds.findPar(adjNodeNo));
                            maxIslands+=ds.size.get(ds.findPar(adjNodeNo));
                        }
                    }
                    maxIslands++;
                    maxIslandsOp = Math.max(maxIslandsOp, maxIslands);
                }

            }
        }

        for(int i=0; i<n*n; i++){
            maxIslandsOp= Math.max(maxIslandsOp, ds.size.get(i));
        }
        return maxIslandsOp;
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1,1},{1,0}}));
    }
}
