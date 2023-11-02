package graph.medium;
import graph.basic.Disjoint;
public class MinOpsToMakeNwConnected {
    public int makeConnected(int n, int[][] connections) {
        Disjoint d = new Disjoint(n);
        int extraCons = 0;
        for (int[] con : connections) {
            if (d.findPar(con[0]) != d.findPar(con[1])) d.unionBySize(con[0], con[1]);
            else extraCons++;
        }

        int components = 0;
        for (int i=0; i<d.parent.size(); i++){
            if(i==d.parent.get(i)) components++;
        }

        // no of min edges to connect n nodes/components is n-1;
        int ans = components-1;
        if(extraCons>=ans) return ans;
        return -1;
    }
}
