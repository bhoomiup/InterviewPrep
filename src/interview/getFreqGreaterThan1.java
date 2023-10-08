package interview;

import java.util.HashMap;
import java.util.Map;

public class getFreqGreaterThan1 {

    // s = "abbccde"
    // {b:2, c:2}
    public static HashMap<Character, Integer> getFrequency(String s){
        HashMap<Character, Integer> op = new HashMap<>();
        for(Character i: s.toCharArray()){
            op.put(i, op.getOrDefault(i, 0)+1);
        }
        for (Map.Entry<Character, Integer> i: op.entrySet()){
            if(i.getValue()>1) System.out.println(i.getKey() +" "+ i.getValue() );
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(getFrequency("abbccde"));
    }
}
