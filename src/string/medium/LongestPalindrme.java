package string.medium;

public class LongestPalindrme {
    public String longestPalindrome(String s) {
        int i = 0;
        int len = s.length();
        int[] longestLen = new int[1];
        int[] indxs = new int[2];
        while(i<len){
            checkOddLenPal(s, i, longestLen, indxs);
            checkEvenLenPal(s, i, longestLen, indxs);
            i++;
        }
        return s.substring(indxs[0], indxs[1]+1);
    }

    public void checkOddLenPal(String s, int index, int[] longestLen, int[] indxs) {
        int len = s.length();
        int start = index;
        int end = index;
        while(start>=0 && end<len && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(((end-start)-1) > longestLen[0]) {
            indxs[0] = start+1;
            indxs[1] = end-1;
        }
    }

    public void checkEvenLenPal(String s, int index, int[] longestLen, int[] indxs) {
        int len = s.length();
        int start = index;
        int end = index+1;
        while(start>=0 && end<len && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(((end-start)-1) > longestLen[0]) {
            indxs[0] = start+1;
            indxs[1] = end-1;
        }
    }
}
