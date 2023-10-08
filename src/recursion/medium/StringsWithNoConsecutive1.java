package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class StringsWithNoConsecutive1 {
    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> op = new ArrayList<>();
        helper(0, N, op, "");
        return op;
    }

    public static void helper(int count, int N, List<String> op, String curr) {
        // Write your code here.
        if(count==N ) {
            op.add(curr);
            return;
        }
        helper(count+1, N, op, curr+'0');
        if(curr.length()==0 || curr.charAt(curr.length()-1)!='1')    helper(count+1, N, op, curr+'1');

    }

    public static void main(String[] args) {
        System.out.println(generateString(3));
    }
}
