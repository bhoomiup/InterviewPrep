package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class generateAllValidParanthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
        helper(n-1, n, "(", op);
        return op;
    }

    public static void helper(int openCount, int closeCount, String op, List<String> final_op){
        if(openCount==0 && closeCount==0) {
            final_op.add(op);
            return;
        }
        String op1 = op+"(";
        String op2 = op+ ")";
        if(openCount!=0){
            helper(openCount-1, closeCount, op1, final_op);
        }
        if(openCount!=closeCount){
            helper(openCount, closeCount-1, op2, final_op);
        }

    }

    public static List<String> generateParenthesis1(int n) {
        List<String> op = new ArrayList<>();
        helper1(n, n, op, "");
        return op;
    }

    public static void helper1(int o, int c, List<String> op, String curr){
        if(o==0 && c==0){
            op.add(curr);
            return;
        }
        if(o>0) helper1(o-1, c, op, curr+"(");
        if(o!=c) helper1(o, c-1, op, curr+")");
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }
}
