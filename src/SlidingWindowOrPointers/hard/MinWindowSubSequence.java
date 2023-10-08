package SlidingWindowOrPointers.hard;

public class MinWindowSubSequence {
    //the minimum (contiguous) substring W of str1, so that str2 is a subsequence of W.

    static String minWindow(String str1, String str2) {
        // code here
        int i = 0, j = 0, k = 0, minLen = Integer.MAX_VALUE, start = -1, end = -1, s1len = str1.length(),
                s2len = str2.length();
        boolean flag = false;
        while (j<s1len && k<s2len){
            if(str1.charAt(j)==str2.charAt(k)){
                if(k==0) i=j;
                k++;
            }
            j++;
        }
        if(k==s2len && j-i+1<minLen){
            minLen = Math.min(j-i+1, minLen);
            flag = true;
            start = i;
            end = j;
        }
        i = s1len-1;
        j = s1len-1;
        k = s2len-1;
        while (j>=0 && k>=0){
            if(str1.charAt(j)==str2.charAt(k)) {
                if(k== s2len-1) i=j;
                k--;
            }
            j--;
        }
        System.out.println(i);
        System.out.println(j);
        if(k<0 && i-j-1<minLen) {
            flag = true;
            start = j+1;
            end = i;
        }
        System.out.println(start);
        System.out.println(end);
        return flag? str1.substring(start, end+1): "";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("geeksforgeeks", "eksrg"));
    }
}
