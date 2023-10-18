package graph.hard;

import java.util.*;
import java.util.stream.Collectors;

class Pair{
    String word;
    int transforms;
    Pair(String word, int transforms){
        this.word = word;
        this.transforms = transforms;
    }
}
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);
        while (!q.isEmpty()){
            Pair temp = q.poll();
            String currWord = temp.word;
            for (int i=0; i<currWord.length(); i++){
                for (char j='a'; j<='z'; j++){
                    char[] newCharArray = currWord.toCharArray();
                    newCharArray[i] = j;
                    String newWord = new String(newCharArray);
                    if (wordSet.contains(newWord)){
                        q.add(new Pair(newWord, temp.transforms+1));
                        wordSet.remove(newWord);
                    }
                    if (currWord.equals(endWord)) return temp.transforms;
                }
            }
        }
        return 0;
    }
}
