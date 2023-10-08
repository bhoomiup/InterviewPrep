package backtracking.hard;

import java.util.ArrayList;
import java.util.List;

public class expressionAddOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> op = new ArrayList<>();
        helper(num, target,(int) num.charAt(0)-'0',1,(int) num.charAt(0)-'0', ""+num.charAt(0), op);
        return op;
    }

    public static void helper(String num, int target,int preNum, int index, int total, String op, List<String> finalOp){
        if(index==num.length()){
            if(total==target) finalOp.add(op);
            return;
        }
        for(int i = index; i<num.length(); i++){
            if(i>index & num.charAt(i)=='0'){
                break;
            }
            int currNum =  Integer.parseInt(num.substring(index, i+1));

            helper(num, target,currNum, i+1, total+ currNum, op+"+"+currNum, finalOp);
            helper(num, target,-currNum,i+1, total- currNum, op+"-"+currNum, finalOp);
            helper(num, target, preNum*currNum,i+1, total-preNum+ currNum*preNum, op+"*"+currNum, finalOp);
        }


    }


    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));
        System.out.println(addOperators("232", 8));
        System.out.println(addOperators("105", 5));

//        System.out.println(addOperators("3456237490", 9191));
        System.out.println(addOperators("00", 0));


    }


}
