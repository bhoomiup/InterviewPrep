package array.medium;

/*minimise the length of the string. In each minimising operation,
geek can remove any two consecutive characters if they are of the form
{"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"}.
 */

import java.util.ArrayList;
import java.util.Stack;

public class geekAndNumberString {
    public static int minLength(String s, int n) {
        // code here
        Stack<ArrayList<Integer>> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stack.empty()){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Character.getNumericValue((s.charAt(i))));
                temp.add(i);
                stack.push(temp);
            }
            else if (stack.peek().get(0)%2==0){
                int temp =stack.peek().get(0);
                if((temp==0 && Character.getNumericValue(s.charAt(i))==9)|| (temp-1 ==Character.getNumericValue(s.charAt(i))) &&  (i- stack.peek().get(1)== 1)){
                    stack.pop();
                }
                else {
                    ArrayList<Integer> temp1 = new ArrayList<>();
                    temp1.add(Character.getNumericValue(s.charAt(i)));
                    temp1.add(i);
                    stack.push(temp1);
                }
            }
            else if (stack.peek().get(0)%2!=0){
                int temp =stack.peek().get(0);
                if((temp==9 && Character.getNumericValue(s.charAt(i))==0)|| (temp+1 ==Character.getNumericValue(s.charAt(i))) && ( i- stack.peek().get(1)== 1)){
                    stack.pop();
                }
                else {
                    ArrayList<Integer> temp1 = new ArrayList<>();
                    temp1.add(Character.getNumericValue(s.charAt(i)));
                    temp1.add(i);
                    stack.push(temp1);
                }
            }

        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength("12213", 5));
        System.out.println(minLength("8734344344334521", 5));
        System.out.println(minLength("76", 5));


    }
}
