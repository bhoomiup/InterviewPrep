package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class permutationsWithSpaces {

    static List<String> permutationsWithSpaces(String ip, int index, String op, List<String> final_op){
        if(index==ip.length()) {
            final_op.add(op);
            return final_op;
        }
        String op1 = op+" "+ip.charAt(index);
        String op2 = op+ip.charAt(index);
        permutationsWithSpaces(ip, index+1, op1, final_op);
        permutationsWithSpaces(ip, index+1, op2, final_op);
        return final_op;
    }

    public static void main(String[] args) {
        String ip = "ABC";
        System.out.println(permutationsWithSpaces(ip.substring(1), 0, ""+ip.charAt(0), new ArrayList<>()));
    }
}
