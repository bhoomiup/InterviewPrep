package graph.medium;

import java.util.*;

public class RestoreArray {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int[] i: adjacentPairs){
            if(mp.containsKey(i[0])) mp.get(i[0]).add(i[1]);
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i[1]);
                mp.put(i[0], temp);
            }
            if(mp.containsKey(i[1])) mp.get(i[1]).add(i[0]);
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i[0]);
                mp.put(i[1], temp);
            }
        }

        int start = 0;
        for(int i:mp.keySet()) {
            if(mp.get(i).size()==1){
                start = i;
                break;
            }
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> op = new ArrayList<>();
        op.add(start);
        visited.add(start);
        int temp = mp.get(start).get(0);
        op.add(temp);
        visited.add(temp);
        while(mp.get(temp).size()>1){
            int first = mp.get(temp).get(0);
            int sec = mp.get(temp).get(1);
            int neighbor = !visited.contains(first)? first: sec;
                op.add(neighbor);
                visited.add(neighbor);
                temp = neighbor;
        }
        return op.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}})).forEach(System.out::println);
    }
}
