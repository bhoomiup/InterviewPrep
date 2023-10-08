package recursion.basic;

import java.util.ArrayList;

public class subSetSumI {

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> op = new ArrayList<>();
        helper(arr, 0, 0, op);
        return op;
    }

    static void helper(ArrayList<Integer> ip, int index, int sum, ArrayList<Integer> op){
        if(index==ip.size()) {
            op.add(sum);
            return;
        }
        // not pick
        helper(ip, index+1, sum, op);
        // pick
        helper(ip, index+1, sum+ip.get(index), op);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(5);
        ip.add(2);
        ip.add(1);

        System.out.println(subsetSums(ip, 8));
    }
}
