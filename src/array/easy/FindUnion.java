package array.easy;

import java.util.ArrayList;
import java.util.List;

public class FindUnion {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        int i = 0;
        int j = 0;
        List<Integer> op = new ArrayList<>();
        while (i<a.length && j<b.length){
            int opSize = op.size();
            if(a[i]<=b[j]) {
                if(opSize>0){
                    if(op.get(op.size()-1) != a[i]) op.add(a[i]);
                }else op.add(a[i]);
                i++;
                if(a[i]==b[j]) j++;
            } else {
                if(opSize>0){
                    if(op.get(op.size()-1)!=b[j]) op.add(b[j]);
                }else op.add(b[j]);
                j++;
            }
        }

        while (i< a.length) {
            if(op.size()>0){
                if(op.get(op.size()-1)!=a[i]) op.add(a[i]);
            }else op.add(a[i]);
            i++;
        }

        while (j< b.length) {
            if(op.size()>0){
                if(op.get(op.size()-1)!=b[j]) op.add(b[j]);
            } else op.add(b[j]);
            j++;
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip1 = {1, 2, 3, 3};
        int[] ip2 = {2, 2, 4};
        System.out.println(sortedArray(ip1, ip2));
    }
}
