package SlidingWindowOrPointers.medium;

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubString {

    static int longestUniqueSubsttr(String S){
        HashSet<Character> freq = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while(j<S.length()){
            if(!freq.contains(S.charAt(j))){
                freq.add(S.charAt(j));
                maxLength = Math.max(maxLength, j+1-i);
                j++;
                continue;
            }

            while (freq.contains(S.charAt(j))){
                freq.remove(S.charAt(i));
                i++;
            }
            freq.add(S.charAt(j));
            j++;
        }
        return maxLength;
    }



    // 20-08-2023
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        HashSet<Character> present = new HashSet<>();
        int op = 0;
        int i = 0;
        int j = 0;
        while(j<s.length()){
            if(!present.contains(s.charAt(j))) {
                present.add(s.charAt(j));
                j++;
                op = Math.max(op, j-i);
            }
            else{
                present.remove(s.charAt(i));
                i++;
            }

        }
        op = Math.max(op, j-i);
        return op;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
