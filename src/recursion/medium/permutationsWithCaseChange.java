package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class permutationsWithCaseChange {

    static List<String> permutationsWithCaseChange(String ip,String op,List<String> final_op){
        if(ip.length()==0) {
            final_op.add(op);
            return final_op;
        }
        op = op + ip.charAt(0);
        ip  = ip.substring(1);
        permutationsWithCaseChange(ip ,op, final_op);
        op = op.substring(0, op.length()-1)+ String.valueOf(op.charAt(op.length()-1)).toUpperCase();
        permutationsWithCaseChange(ip, op, final_op);
        return final_op;
    }

    public static void main(String[] args) {
        System.out.println(permutationsWithCaseChange("ab", "", new ArrayList<>()));
    }
}
