package graph.hard;

import java.util.*;

public class WordLadderii {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> op = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        q.add(temp);
        List < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(beginWord);
        int level = 0;
        while (!q.isEmpty()){
            List<String> curr = q.poll();
            String lastWord = curr.get(curr.size()-1);
            if(curr.size()>level){
                level++;
                for (String it: usedOnLevel) {
                    wordSet.remove(it);
                }
                usedOnLevel.clear();
            }
            if (lastWord.equals(endWord)){
                if(op.size()==0 || op.get(0).size()==curr.size()){
                    op.add(curr);
                }
            }
            for (int i=0; i<lastWord.length(); i++){
                for (char j='a'; j<='z'; j++){
                    char[] newCharArray = lastWord.toCharArray();
                    newCharArray[i] = j;
                    String newWord = new String(newCharArray);
                    if (wordSet.contains(newWord)){
                        curr.add(newWord);
                        ArrayList < String > newSeq = new ArrayList < > (curr);
                        q.add(newSeq);
                        curr.remove(curr.get(curr.size()-1));
                        usedOnLevel.add(newWord);
                    }
                }
            }
        }
        return op;
    }
}
