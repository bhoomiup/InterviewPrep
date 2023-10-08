package string.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()) mp.put(c, mp.getOrDefault(c, 0)+1);

        for(char c: t.toCharArray()){
            if(!mp.containsKey(c)) return false;
            else{
                mp.put(c, mp.getOrDefault(c, 0)-1);
                if(mp.get(c)==0) mp.remove(c);
            }
        }

        return mp.size() == 0;
    }
}
