package string.easy;

public class LargestOddNum {
    public String largestOddNumber(String num) {
        int i;
        char[] charArray = num.toCharArray();
        int n = charArray.length;
        for(i=n-1; i>=0; i--){
            if((charArray[i]-'0')%2!=0) return num.substring(0, i+1);
        }
        return "";
    }
}
