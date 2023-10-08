package string.medium;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.isDigit;

public class MyAtoi {

    public int myAtoi(String s)  {
        int start = 0;
        char sign = 0;
        while(start<s.length() && s.charAt(start)==' '){
            start++;
        }
        if(start<s.length()){
            if(s.charAt(start)=='-') {
                sign = '-';
                start++;
            }else if(s.charAt(start)=='+'){
                sign = '+';
                start++;
            }
        }
        if(start<s.length() && !isDigit(s.charAt(start))) return 0;
        int end = s.length()-1;
        int op = 0;
        for(int i = start; i<=end;i++){
            if(!isDigit(s.charAt(i))) break;
            int temp = (s.charAt(i) - '0');
            //check if total will be overflow after 10 times and add digit
            if (op > (Integer.MAX_VALUE / 10) || (op == (Integer.MAX_VALUE / 10) && temp > 7)){
                return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            op= (10*op)+temp;
        }
        if(sign == '-') op*=-1;
        return op;
    }
}
