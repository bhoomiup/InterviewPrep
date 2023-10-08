package SlidingWindowOrPointers.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SmallestWindowConatiningAllCharInAnotherString {
//    smallest window in the string S consisting of all the characters(including duplicates) of the string P
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        HashMap<Character, Integer> firstStringFreq = new HashMap<>();
        HashMap<Character, Integer> secondStringFreq = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            secondStringFreq.put(p.charAt(i), secondStringFreq.getOrDefault(p.charAt(i), 0)+1);
        }

        int minLength = Integer.MAX_VALUE;
        int startIndex=-1;
        int endIndex=-1;
        int i = 0;
        int j = 0;
        boolean flag = false;
        int count = 0;
        while (j<s.length()){
            if(secondStringFreq.containsKey(s.charAt(j))){
                firstStringFreq.put(s.charAt(j), firstStringFreq.getOrDefault(s.charAt(j), 0)+1);
            }
            if((secondStringFreq.containsKey(s.charAt(j))) && (firstStringFreq.get(s.charAt(j))== secondStringFreq.get(s.charAt(j)))) {
                count++;
            };
            while (count==secondStringFreq.size()){
                if(minLength==j-i+1){
                    startIndex = Math.min(startIndex , i);
                }else {
                    startIndex = i;endIndex = j;
                }
                minLength = Math.min(minLength, j-i+1);
                flag =true;
                if(firstStringFreq.containsKey(s.charAt(i))) {
                    firstStringFreq.put(s.charAt(i), firstStringFreq.get(s.charAt(i)) - 1);
                    if (firstStringFreq.get(s.charAt(i))<secondStringFreq.get(s.charAt(i))) count--;
                }
                i++;
            }
            j++;
        }
        return flag?s.substring(startIndex,endIndex+1): "-1";
    }



    public static String minWindow(String s, String t) {
        int i =0, j=0, slen = s.length(), tlen = t.length();
        Map<Character, Integer> smp = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int[] idx = new int[2];
        while(i<tlen) {
            tmp.put(t.charAt(i), tmp.getOrDefault(t.charAt(i), 0)+1);
            i++;
        }
        i = 0;
        int count = 0;
        while(j<slen){
            if(tmp.containsKey(s.charAt(j))) {
                smp.put(s.charAt(j), smp.getOrDefault(s.charAt(j), 0)+1);
                if(Objects.equals(tmp.get(s.charAt(j)), smp.get(s.charAt(j)))) count++;
            }
            while(count==tmp.size()){
                if(smp.containsKey(s.charAt(i))){
                    smp.put(s.charAt(i), smp.get(s.charAt(i))-1);
                    if(smp.get(s.charAt(i))<tmp.get(s.charAt(i))) count--;
                }
                if(j-i+1<minLen) {
                    minLen = j-i+1;
                    idx[0] = i;
                    idx[1] = j;
                }
                i++;
            }
            j++;
        }
        return s.substring(idx[0], idx[1]+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc"));
        System.out.println(minWindow("zoomlazapzo", "oza"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

    }
}
