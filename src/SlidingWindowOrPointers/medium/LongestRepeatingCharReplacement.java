package SlidingWindowOrPointers.medium;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int i = 0; int j = 0; int maxLength = 0; int maxFreq = 0;
        while (j<s.length()){
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(j)));
            if(j-i+1-maxFreq<=k) maxLength = Math.max(maxLength, j-i+1);
            while (j-i+1-maxFreq>k){
                freq.put(s.charAt(i), freq.get(s.charAt(i))-1);
                i++;
            }
            j++;
        }
        return maxLength;
    }



    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));

    }
}
