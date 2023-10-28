package graph.basic;

import java.util.ArrayList;
import java.util.List;

public class Disjoint {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        // Intialise your data structure here.
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node){
        if(parent.get(node)==node) return node;
        int ultimateParent = findPar(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if(pu==pv) return;
        if(rank.get(pu)<rank.get(pv)) parent.set(pu, pv);
        else if (rank.get(pv)<rank.get(pu)) parent.set(pv, pu);
        else {
            parent.set(pv, pu);
            int rankU = rank.get(u);
            rank.set(u, rankU+1);
        }

    }

    public void unionBySize(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if(pu==pv) return;
        if(size.get(pu)<size.get(pv)){
            parent.set(pu, pv);
            size.set(pv, size.get(pv)+size.get(pu));
        }
        else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }

}
