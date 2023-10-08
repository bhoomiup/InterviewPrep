package heap.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char i : tasks) mp.put(i, mp.getOrDefault(i, 0)+1);

        class Data{
            char c;
            int count;
            Data(char c, int count){
                this.c = c;
                this.count = count;
            }
        }

        PriorityQueue<Data> pq = new PriorityQueue<>((a, b)-> b.count - a.count);

        mp.forEach((k,v) -> pq.add(new Data(k, v)));

        ArrayList<ArrayList<Character>> op = new ArrayList<>();
        while (pq.size()!=0){
            int time = 0;
            ArrayList<Data> temp = new ArrayList<>();
            ArrayList<Character> res = new ArrayList<>();
            while (time<=K){
                if(pq.size()!=0){
                    Data p = pq.poll();
                    if (p.count-1>0) {
                        temp.add(new Data(p.c, p.count-1));
                    }res.add(p.c);
                }else{
                    res.add('x');
                }
                time++;
            }
            op.add(res);
            pq.addAll(temp);
        }
        for(Character i : op.get(op.size()-1)){
            if(i=='x') op.get(op.size()-1).remove(Character.valueOf('x'));
        }
        int count = 0;
        for(ArrayList<Character> i : op) count+= i.size();
        return count;
    }


    public static void main(String[] args) {
//        int N = 6;
//        int K = 2;
//        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
        int N = 12;
        int K = 2;
        char[] task = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(N, K, task));
    }
}
