package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class combinationalSumIII {
    //Find all valid combinations of K numbers that sum upto to N such that the following conditions are true:
    //Only number 1 through 9 are used.
    //Each number is used atmost once.

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> op = new ArrayList<>();
        int[] ip = {1, 2, 3 , 4, 5, 6, 7, 8, 9 };
        helper(ip, 0, k, n, 0,new ArrayList<>(), op);
        return op;
    }

    public static void helper(int[] ip, int index, int k, int sum, int temp_sum, List<Integer> op, List<List<Integer>>  final_op){
        if(op.size()==k){
            if(temp_sum==sum){
                final_op.add(new ArrayList<>(op));
            }
            return;
        }
        for(int i=index; i<ip.length; i++){
            if(temp_sum>sum) continue;
            op.add(ip[i]);
            helper(ip, i+1, k, sum, temp_sum+ip[i], op, final_op);
            op.remove(op.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum3_(int k, int n) {
        int[] ip = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> op = new ArrayList<>();
        helper_(k, n, ip, op, new ArrayList<>(), 0);
        return op;
    }

    public static void helper_(int maxLen, int target, int[] ip, List<List<Integer>> op,
                               List<Integer> curr, int index){
        if(curr.size()==maxLen){
            if(target==0) op.add(new ArrayList<>(curr));
            return;
        }
        if(target<0) return;
        for(int i = index; i<ip.length; i++){
            curr.add(ip[i]);
            helper_(maxLen, target-ip[i], ip, op, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
//        System.out.println(combinationSum3_(3, 7));
        System.out.println(combinationSum3_(3, 9));
//        System.out.println(combinationSum3(4, 1));
//        System.out.println(combinationSum3(9, 45));


    }


    }
