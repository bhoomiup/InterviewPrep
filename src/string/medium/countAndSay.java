package string.medium;

public class countAndSay {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String op = "1";
        helper(n, 1, op);
        return op;
    }

    public  static void helper(int n, int index, String op){
        System.out.println(op);
        if(index==n) return;
        int count = 0;
        char currChar = op.charAt(0);
        System.out.println(currChar);
        StringBuilder currString = new StringBuilder();
        for(int i=0; i<op.length(); i++){
            if(op.charAt(i)==currChar) count++;
            else{
                currString.append(count).append(currChar);
                currChar = op.charAt(i);
                count = 0;
            }
        }
        currString.append(count).append(currChar);
        System.out.println(currString);
        helper(n, index+1, currString.toString());
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }
}
