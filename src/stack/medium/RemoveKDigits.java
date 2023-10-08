package stack.medium;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        // code here
        {
            if(num.length()<=k) return "0";
            Stack<Character> chars = new Stack<>();
            int count = 0;
            for(int i=0; i<num.length(); i++){
                if(chars.empty() || count==k || chars.peek()<=num.charAt(i)){
                    chars.push(num.charAt(i));
                }
                else{
                    while (!chars.empty() && chars.peek()>num.charAt(i) && count<k){
                        chars.pop();
                        count++;
                    }
                    chars.push(num.charAt(i));
                }

            }
            String op = chars.stream().map(Object::toString).collect( Collectors.joining() );
            int i = 0;
            while ( op.charAt(i)=='0'&& i<op.length()-1){
                i++;
            }
            op = op.substring(i);
            if(count<k){
                if(op.length()<=(k-count)) op = "0";
                else op = op.substring(0, op.length()-(k-count));
            }
            return op;
        }
    }


    public static String removeKdigits1(String num, int k){
        Stack<Integer> s = new Stack<>();
        for(char i: num.toCharArray()){
            int temp = Integer.parseInt(String.valueOf(i));
            if(s.isEmpty() || s.peek()<=temp) s.add(temp);
            else {

                while (k>0 && !s.isEmpty() && s.peek()>temp){
                    s.pop();
                    k--;
                }
                s.add(temp);
            }
        }
        while (k>0) {
            s.pop();
            k--;
        }

        StringBuilder op1 = s.parallelStream().collect(StringBuilder::new, StringBuilder::append,
                StringBuilder::append);
        int i = 0;
        String op = op1.toString();
        while (i < op.length() && op.charAt(i) == '0')
            i++;
        if(i>op.length()-1) return "0";

        return op.substring(i);
    }

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        removeKdigits("10200", 1);
//        removeKdigits("10", 2);
//        removeKdigits("149811", 3);
//        System.out.println(removeKdigits("1002991", 3  ));
        System.out.println(removeKdigits1("10001", 4  ));
//        System.out.println(removeKdigits1("112", 1  ));
//        System.out.println(removeKdigits1("1173", 2  ));


    }
}
