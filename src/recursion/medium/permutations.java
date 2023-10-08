package recursion.medium;

import java.util.*;

public class permutations {

    // method 1 - using extra map ds
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> op = new ArrayList<>();
//        helper(nums, new HashMap<>(), new ArrayList<>(), op);
//        return op;
//    }
//
//    static void helper(int[] ip, HashMap<Integer, Integer> pickedEles, List<Integer> op, List<List<Integer>> final_op){
//        if(op.size()== ip.length){
//            final_op.add(new ArrayList<>(op));
//            return;
//        }
//        for(int i=0; i<ip.length; i++){
//            if (!pickedEles.containsKey(ip[i])) {
//                op.add(ip[i]);
//                pickedEles.put(ip[i],1);
//                helper(ip, pickedEles, op, final_op);
//                op.remove(op.size()-1);
//                pickedEles.remove(ip[i]);
//            }
//        }
//    }

    // method 2 - without using extra ds
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray(); //to avoid dups
        helper(nums, 0, op);
        return op;
    }

    static void helper(int[] ip, int index, List<List<Integer>> final_op){
        if(index == ip.length){
            final_op.add(new ArrayList<>(Arrays.stream(ip).boxed().toList()));
            return;
        }
        for(int i=index; i<ip.length; i++){
            if(i>index && (ip[index]==ip[i] || ip[i-1]==ip[i])) continue; // to avoid duplicates
            int temp1 = ip[i];
            ip[i] = ip[index];
            ip[index] = temp1;
            helper(ip, index+1, final_op);
            ip[index] = ip[i];
            ip[i] = temp1;
        }
    }
    public static void main(String[] args) {
//        int[] ip = {1,1,2};
//        int[] ip = {3,3,0,3 };
        int[] ip = {0,1,0,0,9 };

        System.out.println(permute(ip));
    }
}
