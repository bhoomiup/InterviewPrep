package array.easy;

import java.util.ArrayList;
import java.util.List;

public class leaders {

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int maxEle = arr[arr.length-1];
        ArrayList<Integer> op = new ArrayList<>();
        op.add(maxEle);
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] >= maxEle){
                op.add(arr[i]);
                maxEle = arr[i];
            }
        }
        int i = 0;
        int j = op.size()-1;
        while(i<j){
            int val = op.get(i);
            op.set(i, op.get(j));
            op.set(j, val);
            i++;
            j--;
        }
        return op;
    }

    // 28-07-2023
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.

        int currLargest = a[a.length-1];
        List<Integer> op = new ArrayList<>();
        op.add(currLargest);
        for(int i=a.length-2; i>-1; i--){
            if(a[i]>=currLargest) {
                currLargest = a[i];
                op.add(currLargest);
            }
        }
        return op;
    }

    public static void main(String[] args) {
//        int[] ip =  {16,17,4,3,5,2};
        int[] ip =  {1,2,3,4,0};
        System.out.println(leaders(ip, ip.length));
    }
}
