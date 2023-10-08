package recursion.medium;

import java.util.ArrayList;

public class NbitBinaryNoHavingMore1sThan0s {

    static ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> op = new ArrayList<>();
        helper(N, 0, 0, "", op);
        return op;
    }

    static void helper(int N, int count0, int count1, String op, ArrayList<String> final_op){
        if(op.length()==N){
            final_op.add(op);
            return;
        }
        op = op+"1";
        helper(N, count0, count1+1, op, final_op);
        op = op.substring(0, op.length()-1);
        if(count0<count1){
            op = op+"0";
            helper(N, count0+1, count1, op, final_op);
        }

    }

    public static void main(String[] args) {
        System.out.println(NBitBinary(4));
    }

}
