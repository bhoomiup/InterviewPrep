package recursion.medium;

import java.util.*;

public class subSetsII {

    //Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
    //
    //The solution set must not contain duplicate subsets. Return the solution in any order.
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> final_op = new ArrayList<>();
        final_op.add(new ArrayList<>());
        helper(nums, 0, new ArrayList<>(), final_op);
        return final_op;

    }

    public static void helper(int[] ip, int index, List<Integer> op, List<List<Integer>> final_op){
        if(index== ip.length){
            return;
        }
        for(int i=index; i<ip.length; i++){
            if(i>index && ip[i]==ip[i-1]) continue;
            List<Integer> op1 = new ArrayList<>(op);
            op1.add(ip[i]);
            final_op.add(op1);
            helper(ip, i+1, op1, final_op);
        }
    }


    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        helper2(nums, op, 0, new ArrayList<>());
        return op;
    }

    public void helper2(int[] nums, List<List<Integer>> op, int index, List<Integer> curr)
    {
        if(index==nums.length) {
            op.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            helper2(nums, op, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }






















    public static List<Integer> subsetSum1(int num[]) {
        // Write your code here..
        Set<Integer> op = new HashSet<>();
        helper1(num, 0, 0, op);
        return op.stream().toList();
    }

    public static void helper1(int[] candidates, int sum, int index, Set<Integer> op){
        op.add(sum);
        for(int i = index; i<candidates.length; i++){
            helper1(candidates, sum+candidates[i], i+1, op);
        }
    }
    public static void main(String[] args) {
//        int[] ip = {1, 2, 2};
//          int[] ip = {0};
        int[] ip = {1, 2, 3};
        System.out.println(subsetSum1(ip));
//        System.out.println(subsetsWithDup(ip));
    }
}
