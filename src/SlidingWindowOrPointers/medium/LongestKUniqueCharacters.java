package SlidingWindowOrPointers.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestKUniqueCharacters {

//    public static int longestkSubstr(String s, int k) {
//        // code here
//        HashMap<Character, Integer> charSet = new HashMap<>();
//        int maxLength = 0;
//        int i = 0;
//        int j = 0;
//        while (j<s.length()){
//            charSet.put(s.charAt(j), charSet.getOrDefault(s.charAt(j), 0)+1);
//            if (charSet.size()==k){
//                maxLength = Math.max(maxLength, j-i+1);
//            }
//            while (charSet.size()>k){
//                charSet.put(s.charAt(i), charSet.get(s.charAt(i))-1);
//                if(charSet.get(s.charAt(i))==0){
//                    charSet.remove(s.charAt(i));
//                }
//                i++;
//            }
//            j++;
//        }
//        return maxLength>0?maxLength:-1;
//    }

    // code here

    public static int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> mp = new HashMap<>();
        int op = -1;
        int i = 0;
        int j = 0;
        int len = s.length();
        while(j<len){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
            while(mp.size()>k){
                mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
                if( mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                i++;
            }
            if(mp.size()==k) op = Math.max(op, j-i+1);
            j++;
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aaaa", 3));
    }
}
