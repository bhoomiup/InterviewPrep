package recursion.medium;


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class print1SubsequenceWithSumK {

    public static void   subsetWithSumK(int[] nums, int k) {
        ArrayList<Integer> ip = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        helper(ip, 0, 0, k);
    }
    public static boolean helper(ArrayList<Integer> ip,  int index, int sum, int k){
        if(index==ip.size() ) {
            if(sum==k) {
                return true;
            }
            return false;
        }
        if(helper(ip,  index+1, sum, k)) return true;
        if(helper(ip,  index+1, sum+ip.get(index), k)) return true;
        return false;
    }

    public static boolean isSubsetPresent( int k,int []a) {
        // Write your code here
        return helper1(a, 0,  0, k);
    }

    public static boolean helper1(int[] nums, int index, long sum, long k) {
        if (index > nums.length - 1) {
            if (sum == k) return true;
            return false;
        }
        if(helper1(nums, index + 1, sum + nums[index], k)) return true;
        if(helper1(nums, index + 1, sum, k)) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 1};
        System.out.println(isSubsetPresent(2, ip));
    }
}
