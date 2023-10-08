package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class printAllSubsets {
    static List<List<Integer>> final_op = new ArrayList<>();
    public static List<List<Integer>>  subsets(int[] nums) {
        ArrayList<Integer> ip = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> op = new ArrayList<>();
        helper(ip, op, 0);
        return final_op;
    }

    public static void helper(ArrayList<Integer> ip,ArrayList<Integer> op, int index){
        if(index==ip.size()) {
            final_op.add(op);
            return;
        }
        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 =  new ArrayList<>(op);
        op2.add(ip.get(index));
        //not pick
        helper(ip, op1, index+1);
        // pick
        helper(ip, op2, index+1);
    }
























    public static List<List<Integer>>  subsets1(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        helper1(nums, 0, op, new ArrayList<>());
        return op;
    }

    public static void helper1(int[] nums, int index, List<List<Integer>> op, List<Integer> curr){
        if(index>nums.length-1){
            op.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper1(nums, index+1, op, curr);
        curr.remove(curr.size()-1);
        helper1(nums, index+1, op, curr);
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 3};
        System.out.println(subsets1(ip));
    }
}
