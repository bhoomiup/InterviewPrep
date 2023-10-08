package recursion;

import java.util.HashMap;
import java.util.HashSet;

public class test {

    public static HashSet<Character> countOfChar(String ip){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char i : ip.toCharArray()){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        HashSet<Character> al = new HashSet<>();
        for(Character i : freq.keySet()){
            if(freq.get(i)>1) al.add(i);
        }
        return al;
    }
    public static void main(String[] args) {
        System.out.println(countOfChar("java developer"));
    }
}
