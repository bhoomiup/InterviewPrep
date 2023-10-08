package recursion.medium;

import java.util.*;
import java.util.stream.Collectors;

public class combinationalSumII {
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
// in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.

//    Method 1
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        candidates = Arrays.stream(candidates).sorted().toArray();
//        HashSet<List<Integer>> final_op = new HashSet<>();
//        helper(candidates, 0, target, 0, new ArrayList<>(), final_op );
//        return final_op.stream().toList();
//    }
//
//    public static void helper(int[] ip, int sum, int k, int index,  List<Integer> op, HashSet<List<Integer>> final_op ){
//        if(sum==k) {
//            final_op.add(op);
//            return;
//        }
//        if(index==ip.length) return;
//        List<Integer> op1 = new ArrayList<>(op);
//        List<Integer> op2 =  new ArrayList<>(op);
//        op2.add(ip[index]);
//        //not pick
//        helper(ip, sum, k, index+1, op1, final_op);
//        //pick
//        helper(ip, sum + ip[index], k, index+1, op2, final_op);
//
//    }
//    Method 1
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        candidates = Arrays.stream(candidates).sorted().toArray();
//        HashSet<List<Integer>> final_op = new HashSet<>();
//        helper(candidates, 0, target, 0, new ArrayList<>(), final_op );
//        return final_op.stream().toList();
//    }

//     Method 2

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidates = Arrays.stream(candidates).sorted().toArray();
        List<List<Integer>> final_op = new ArrayList<>();
        helper(candidates, 0, target, 0, new ArrayList<>(), final_op );
        return final_op.stream().toList();
    }
    public static void helper(int[] ip, int sum, int k, int index,  List<Integer> op, List<List<Integer>> final_op ){
        if(sum==k) {
            final_op.add(op);
            return;
        }
        if(index==ip.length) return;

        for(int i = index; i<ip.length; i++ ) {
            if (i > index && ip[i] == ip[i - 1]) continue;
            if (sum < k) {
                //pick
                List<Integer> op1 = new ArrayList<>(op);
                op1.add(ip[i]);
                helper(ip, sum + ip[i], k, i + 1, op1, final_op);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if(sum>target) return;
        for(int i = index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            helper1(candidates, target, sum+candidates[i], i+1, curr, op);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] ip = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(ip, 8));
    }
}
