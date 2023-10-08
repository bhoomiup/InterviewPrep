package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class printAllSubsequenceWithSumK {

    public static void   subsetsWithSumK(int[] nums, int k) {
        ArrayList<Integer> ip = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> op = new ArrayList<>();
        helper(ip, op, 0, 0, k);
    }
    public static void helper(ArrayList<Integer> ip, ArrayList<Integer> op, int index, int sum, int k){
        if(index==ip.size() ) {
            if(sum==k) System.out.println(op);
            return;
        }
        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 =  new ArrayList<>(op);
        op2.add(ip.get(index));
        helper(ip, op1, index+1, sum, k);
        helper(ip, op2, index+1, sum+ip.get(index), k);
    }


    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        // Write your code here
        List<List<Integer>> op = new ArrayList<>();
        a = Arrays.stream(a).sorted().toArray();
        helper1(a, 0, op, new ArrayList<>(), 0, k);
        return op;
    }

    public static void helper1(int[] nums, int index, List<List<Integer>> op, List<Integer> curr, long sum, long k) {
        if (index > nums.length - 1) {
            System.out.println(curr);
            if (sum == k && ((op.size()==0 || op.get(op.size() - 1) != curr))) op.add(new ArrayList<>(curr));
            return;
            }
            curr.add(nums[index]);
            helper1(nums, index + 1, op, curr, sum + nums[index], k);
            curr.remove(curr.size() - 1);
            helper1(nums, index + 1, op, curr, sum, k);
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 1, 1, 1};
        System.out.println(subarraysWithSumK(ip, 3));
    }
}
