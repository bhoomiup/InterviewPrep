package recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class possibleWordsFromPhoneDigs {

    static ArrayList<String> possibleWords(int a[], int N)
    {
        // your code here
        ArrayList<String> op = new ArrayList<>();
        HashMap<Integer, String> ref_ip = new HashMap<>();
        ref_ip.put(2, "abc");
        ref_ip.put(3, "def");
        ref_ip.put(4, "ghi");
        ref_ip.put(5, "jkl");
        ref_ip.put(6, "mno");
        ref_ip.put(7, "pqrs");
        ref_ip.put(8, "tuv");
        ref_ip.put(9, "wxyz");
        helper(ref_ip, a, 0, "", op);
        return op;
    }

    static void helper(HashMap<Integer, String> ref_ip, int[] ip, int index, String op, ArrayList<String> final_op){
        if(index==ip.length) {
            final_op.add(op);
            return;
        }

        for (int j=0; j<ref_ip.get(ip[index]).length(); j++){
            op = op + ref_ip.get(ip[index]).charAt(j);
            helper(ref_ip, ip, index+1, op, final_op);
            op = op.substring(0, index);
        }

    }


    public List<String> letterCombinations(String digits) {
        List<String> op = new ArrayList<>();
        HashMap<Character, String> ref_ip = new HashMap<>();
        ref_ip.put('2', "abc");
        ref_ip.put('3', "def");
        ref_ip.put('4', "ghi");
        ref_ip.put('5', "jkl");
        ref_ip.put('6', "mno");
        ref_ip.put('7', "pqrs");
        ref_ip.put('8', "tuv");
        ref_ip.put('9', "wxyz");
        helper(ref_ip, op, digits, 0, "");
        return op;
    }

    public void helper(HashMap<Character, String> ref_ip, List<String> op, String digits, int index, String curr){
        if(index==digits.length()) {
            op.add(curr);
            return;
        }

        for(int j = 0; j<ref_ip.get(digits.charAt(index)).length(); j++){
            curr = curr+ref_ip.get(digits.charAt(index)).charAt(j);
            helper(ref_ip, op, digits, index+1, curr);
            curr = curr.substring(0, index);
        }
    }

    public static void main(String[] args) {
        int[] ip = {2, 3, 4};
        System.out.println(possibleWords(ip, ip.length));
    }
}
