package array.easy;

import java.util.ArrayList;

public class unionOfArray {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        int i = 0, j = 0;
        ArrayList<Integer> op = new ArrayList<>();
        if(arr1[i]<arr2[j]){
            op.add(arr1[i]);
            i++;
        }
        else{
            op.add(arr2[j]);
            j++;
        }
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                if (op.get(op.size()-1) !=arr1[i]){
                    op.add(arr1[i]);
                }
                i++;
            }
            else if(arr1[i]>=arr2[j]){
                if (op.get(op.size()-1) !=arr2[j]){
                    op.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<n){
            if (op.get(op.size()-1) !=arr1[i]){
                op.add(arr1[i]);
            }
            i++;
        }

        while(j<m){
            if (op.get(op.size()-1) !=arr2[j]){
                op.add(arr2[j]);
            }
            j++;
        }
        return op;
    }

    public static void main(String[] args) {
        int[] arr1 =  {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
    }
}
