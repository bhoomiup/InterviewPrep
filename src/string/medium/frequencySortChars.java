package string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Data{
    int count;
    char character;
    Data(char character,int count){
        this.character = character;
        this.count = count;
    }
}

public class frequencySortChars {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        PriorityQueue<Data> pq = new PriorityQueue<>((x1, x2)->x2.count-x1.count);

        for(char c: s.toCharArray()) mp.put(c, mp.getOrDefault(c, 0)+1);
        for(Map.Entry<Character, Integer> c: mp.entrySet()) {
            pq.add(new Data(c.getKey(), c.getValue()));
        }

        StringBuilder op = new StringBuilder();

        while(!(pq.isEmpty())){
            Data temp = pq.poll();
            while(temp.count>0){
                op.append(temp.character);
                temp.count--;
            }
        }
        return op.toString();
    }
}
