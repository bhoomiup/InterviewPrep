package backtracking.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordHash = new HashSet<>(wordDict);
        return helper(s, wordHash, 0);
    }

    public static boolean helper(String ip, HashSet<String> wordDict, int index){
        if(ip.length()==0) return true;
        for(int i=0; i<ip.length(); i++){
            if(wordDict.contains(ip.substring(0, i+1))) {
                if(helper(ip.substring(i+1), wordDict,  i+1)) return true;
            }
        }
        return false;
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return helper1(s, dict, 0);
    }

    public static boolean helper1(String s, Set<String> dict, int start){
        System.out.println(start);
        if(start==s.length()){
            return true;
        }
        for(int i = start; i<s.length(); i++){
            if(dict.contains(s.substring(start, i+1)) && helper1(s, dict, i+1))  return true ;
        }
        return false;
    }



    public static void main(String[] args) {
//        List<String> wordDict = Arrays.stream(new String[]{"leet", "code"}).toList();
//        System.out.println(wordBreak("leetcode", wordDict));
//        List<String> wordDict = Arrays.stream(new String[]{"apple","pen"}).toList();
//        System.out.println(wordBreak("applepenapple", wordDict));
//        List<String> wordDict = Arrays.stream(new String[]{"cats","dog","sand","and","cat"}).toList();
//        System.out.println(wordBreak("catsandog", wordDict));
//        List<String> wordDict = Arrays.stream(new String[]{"i", "like", "sam",
//                "sung", "samsung", "mobile",
//                "ice","cream", "icecream",
//                "man", "go", "mango" }).toList();
        List<String> wordDict = Arrays.stream(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",
                "aaaaaaaa","aaaaaaaaa","aaaaaaaaaa" }).toList();
        System.out.println(wordBreak1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
    }
}
