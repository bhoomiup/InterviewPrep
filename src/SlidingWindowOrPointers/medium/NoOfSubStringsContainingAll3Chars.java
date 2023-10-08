package SlidingWindowOrPointers.medium;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubStringsContainingAll3Chars {

//    public static int numberOfSubstrings(String s) {
//        HashMap<Character, Integer> freq = new HashMap<>();
//        int i = 0; int j = 0; int count = 0; int end = s.length()-1;
//        while(j<s.length()){
//            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0)+1);
//            while(freq.size()==3 && i<s.length()){
//                System.out.println(freq);
//                count += 1+ (end-j);
//                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)-1);
//                if(freq.get(s.charAt(i))==0) freq.remove(s.charAt(i));
//                i++;
//            }
//            j++;
//        }
//        return count;
//    }

    public static int numberOfSubstrings(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = s.length();
        int count = 0;
        while(j<len){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
            while(mp.size()==3){
                count+=(1+(len-1-j));
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)-1);
                if(mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));

    }
}
