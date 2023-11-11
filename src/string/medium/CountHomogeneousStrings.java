package string.medium;

public class CountHomogeneousStrings {
    public static int countHomogenous(String s) {
        int res = 1;
        int len = 1;
        int i =0;
        int j =1;
        while(j<s.length()){
            if(s.charAt(j)!=s.charAt(j-1)) {
                len=1;
                i=j;
            }
            else len= (j-i+1);
            res= (int) ((res+len)%(1e9+7));
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
    }
}
