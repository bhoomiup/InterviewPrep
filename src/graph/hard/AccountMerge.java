package graph.hard;

import graph.basic.Disjoint;

import java.util.*;

public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // union accounts
        Map<String, Integer> map = new HashMap<>();
        Disjoint ds = new Disjoint(accounts.size()-1);
        for(int i=0; i<accounts.size();i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String currEmail = accounts.get(i).get(j);
                if(!map.containsKey(currEmail)) map.put(currEmail, i);
                else ds.unionBySize(map.get(currEmail), i);
            }
        }
        /// prepare merged accounts
        List<List<String>> mergedAcc = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) mergedAcc.add(new ArrayList<>());
        for(Map.Entry<String, Integer> m: map.entrySet()){
            mergedAcc.get(ds.findPar(m.getValue())).add(m.getKey());
        }
        // preapre op
        List<List<String>> op = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            if (mergedAcc.get(i).size()==0) continue;
            List<String> acc = mergedAcc.get(i);
            Collections.sort(acc);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(acc);
            op.add(temp);
        }
        return op;
    }

    public static void main(String[] args) {
        List<List<String>> ip = new ArrayList<>();
        ip.add(List.of("John","johnsmith@mail.com","john_newyork@mail.com"));
        ip.add(List.of("John","johnsmith@mail.com","john00@mail.com"));
        ip.add(List.of("Mary","mary@mail.com"));
        ip.add(List.of("John","johnnybravo@mail.com"));
        System.out.println(accountsMerge(ip));
    }
}
