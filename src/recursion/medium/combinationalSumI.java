package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationalSumI {

    //Given an array of distinct integers candidates and a target integer target, return a list of all unique
    // combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
    //
    //The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
    //frequency
    // of at least one of the chosen numbers is different.
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> final_op = new ArrayList<>();
        helper(candidates, 0, target, 0, new ArrayList<>(), final_op );
        return final_op;
    }

    public static void helper(int[] ip, int sum, int k, int index,  List<Integer> op, List<List<Integer>> final_op ){
        if(index==ip.length) return;
        if(sum==k) {
            final_op.add(op);
            return;
        }
        List<Integer> op1 = new ArrayList<>(op);
        List<Integer> op2 =  new ArrayList<>(op);
        op2.add(ip[index]);
        //not pick
        helper(ip, sum, k, index+1, op1, final_op);
        //pick
        if(sum<k) {
            helper(ip, sum + ip[index], k, index, op2, final_op);
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        candidates = Arrays.stream(candidates).sorted().toArray();
        List<List<Integer>> op = new ArrayList<>();
        helper1(candidates, target, 0, 0, new ArrayList<>(), op);
        return op;
    }

    public static void helper1(int[] candidates, int target, int sum, int index, List<Integer> curr, List<List<Integer>> op){
        if(sum==target) {
            op.add(new ArrayList<>(curr));
            return;
        }
        if(index>candidates.length-1 || sum>target) return;
        curr.add(candidates[index]);
        helper1(candidates, target, sum+candidates[index], index, curr, op);
        curr.remove(curr.size()-1);
        helper1(candidates, target, sum, index+1, curr, op);
    }
    public static void main(String[] args) {
        int[] ip = {2,3,6,7};
        System.out.println(combinationSum(ip, 7));
    }
}
