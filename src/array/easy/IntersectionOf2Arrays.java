package array.easy;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOf2Arrays {
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        HashSet<Integer> uniqueEle = new HashSet<>();
        ArrayList<Integer> op = new ArrayList<>();
        for(int i : a){
            uniqueEle.add(i);
        }

        for(int i: b){
            if(uniqueEle.contains(i)){
                if(op.size()==0){
                    op.add(i);
                } else if (op.get(op.size()-1)!=i) {
                    op.add(i);
                }
            }
        }
        return op.size();
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] b = {3, 4, 5, 6, 7};
        int[] a = {89, 24, 75, 11, 23};
        int[] b =  {89, 2, 4};
        System.out.println(NumberofElementsInIntersection(a, b, a.length, b.length));
    }
}
