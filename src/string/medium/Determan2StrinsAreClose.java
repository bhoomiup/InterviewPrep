package string.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Determan2StrinsAreClose {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<word1.length(); i++) map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);
        for(int i=0; i<word2.length(); i++) map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
        if(map1.size()!=map2.size()) return false;
        List<Integer> freq1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> freq2 = map2.values().stream().sorted().collect(Collectors.toList());
        for(char i: map1.keySet()) if(!map2.containsKey(i)) return false;
        for(int i=0; i<freq1.size(); i++) if(!Objects.equals(freq1.get(i), freq2.get(i))) return false;
        return true;
    }
}
