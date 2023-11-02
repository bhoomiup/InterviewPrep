package graph.hard;

import graph.basic.Disjoint;

import java.util.*;

public class RemoveNodeWithSameRowOrCol {
    public int removeStones(int[][] stones) {
        int maxRow = Arrays.stream(stones).mapToInt(x->x[0]).max().orElse(-1);
        int maxCol = Arrays.stream(stones).mapToInt(x->x[1]).max().orElse(-1);
        Disjoint d = new Disjoint(maxRow+maxCol);
        Set<Integer> set = new HashSet<>();
        for(int[] i :stones ){
            int u= i[0];
            int v= i[1]+maxRow+1;
            d.unionBySize(u, v);
            set.add(u);
            set.add(v);
        }

        int components = 0;
        for(int i: set){
            if(d.findPar(i)==i) components++;
        }
        return stones.length-components;
    }
}
