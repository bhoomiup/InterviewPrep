package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class restoreIPAddress {

    public static List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return new ArrayList<>();
        List<String> finalOp = new ArrayList<>();
        helper(s, 0, 0, "", finalOp);
        return finalOp;
    }

    public static void helper(String s, int partCount, int index, String op, List<String> finalOp){
        if (index==s.length() && partCount==4){
            finalOp.add(op.substring(0, op.length()-1));
            return;
        }
        if(partCount>4) return;
        for(int part=index; part<Math.min(index+3, s.length()); part++){
            int currPart = Integer.parseInt(s.substring(index, part+1));
            if (currPart <=255 & (part==index | s.charAt(index)!='0')){
                helper(s, partCount+1, part+1, op+s.substring(index, part+1)+".", finalOp);
            }

        }

    }

    public static void main(String[] args) {
        String ip = "101023";
        System.out.println( restoreIpAddresses(ip));
    }
}


