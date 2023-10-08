package string.easy;

import java.util.HashMap;

public class RomanToInt {

    public int romanToInt(String s) {
        HashMap<Character, Integer> roman_to_int = new HashMap<>();
        roman_to_int.put('I', 1);
        roman_to_int.put('V', 5);
        roman_to_int.put('X', 10);
        roman_to_int.put('L', 50);
        roman_to_int.put('C', 100);
        roman_to_int.put('D', 500);
        roman_to_int.put('M', 1000);
        int op = 0;
        op+= roman_to_int.get(s.charAt(s.length()-1));
        int i;
        for(i=s.length()-2; i>=0; i--){
            Integer temp = roman_to_int.get(s.charAt(i));
            if(temp<roman_to_int.get(s.charAt(i+1))){
                op-=temp;
            }else{
                op+=temp;
            }
        }
        return op;
    }
}
