package graph.hard;

import java.util.*;

public class WordLadderii {

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)  {
//        Set<String> wordSet = new HashSet<>(wordList);
//        Queue<List<String>> q = new LinkedList<>();
//        List<String> currOp = new ArrayList<>();
//        currOp.add(beginWord);
//        q.add(currOp);
//        wordSet.remove(beginWord);
//        List<List<String>> op = new ArrayList<>();
//        while (!q.isEmpty()){
//            List<String> temp = q.poll();
//            String currWord = temp.get(temp.size()-1);
//            for (int i=0; i<currWord.length(); i++){
//                for (char j='a'; j<='z'; j++){
//                    char[] newCharArray = currWord.toCharArray();
//                    newCharArray[i] = j;
//                    String newWord = new String(newCharArray);
//                    if (wordSet.contains(newWord)){
//                        temp.seq.add(newWord);
//                        q.add(new Pair(newWord, temp.seq));
//                        wordSet.remove(newWord);
//                    }
//                    if (newWord.equals(endWord)) op.add(new ArrayList<>(temp.seq));
//                }
//            }
//        }
//        return op;
//    }
}
