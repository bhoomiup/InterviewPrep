package array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> op = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        int count = 0;
        temp1.add(1);
        op.add(temp1);
        count++;
        if(count==numRows) return op;
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        op.add(temp2);
        count++;
        if(count==numRows) return op;
        ArrayList<Integer> temp3 = new ArrayList<>();
        temp3.add(1);
        temp3.add(1);
        helper(temp3, op, count, numRows);
        return op;
    }

    static void helper(ArrayList<Integer> arr, List<List<Integer>> op, int count, int numsRows){
        if(count==numsRows) return;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        for(int i=1; i<count; i++) temp.add(arr.get(i)+arr.get(i-1));
        temp.add(1);
        op.add(temp);
        count = count+1;
        helper(temp, op, count, numsRows);
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
