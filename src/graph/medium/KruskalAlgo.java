package graph.medium;
import graph.basic.Disjoint;

import java.util.Arrays;
import java.util.Comparator;


public class KruskalAlgo {
    public static int kruskalMST(int n,int [][]edges) {
        //Write your code here

        Disjoint d = new Disjoint(n);
        Arrays.sort(edges, Comparator.comparingInt(x->x[2]));
        int op = 0;
        for (int[] edge : edges) {
            if (d.findPar(edge[0]) != d.findPar(edge[1])) {
                op += edge[2];
                d.unionBySize(edge[0], edge[1]);
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{1, 2, 6}, {1, 3, 5}, {3, 4, 4}, {1, 4, 1}, {1, 3, 2}, {3, 5, 3}};
        System.out.println(kruskalMST(n , edges));
    }
}
