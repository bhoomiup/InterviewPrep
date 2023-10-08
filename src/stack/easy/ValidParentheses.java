package stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(' );
        brackets.put('}','{' );
        brackets.put(']','[' );
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char charc = s.charAt(i);
            if(charc=='('| charc=='[' | charc=='{') stack.push(charc);
            else {
                if (stack.size()!=0)
                {
                    if(stack.peek() ==brackets.get(charc)) stack.pop();
                    else stack.push(charc);
                }
                else return false;

            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        ValidParentheses t1 =  new ValidParentheses();
        System.out.println(t1.isValid("){"));
    }
}
