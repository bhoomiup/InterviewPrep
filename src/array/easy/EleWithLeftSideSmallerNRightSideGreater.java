package array.easy;

import java.util.ArrayList;

public class EleWithLeftSideSmallerNRightSideGreater {

    public static int findElement(int arr[], int n){
        ArrayList<Integer> greatest_left = new ArrayList<>();
        greatest_left.add(arr[0]);
        ArrayList<Integer> smallest_right = new ArrayList<>();
        smallest_right.add(arr[arr.length-1]);
        // preparing array having the greatest eles in the left at any point
        for(int i=1; i<arr.length; i++){
            int prev_ele = greatest_left.get(greatest_left.size()-1);
            greatest_left.add(Math.max(arr[i-1], prev_ele));
        }
        // preparing array having the smallest eles in the right at any point
        for(int i=arr.length-1; i>0; i--){
            int prev_ele = smallest_right.get(smallest_right.size()-1);
            smallest_right.add(Math.min(arr[i], prev_ele));
        }
        // reversing smallest_right
        int i = 0, j = smallest_right.size()-1;
        while (i<j){
            int temp = smallest_right.get(j);
            smallest_right.set(j, smallest_right.get(i));
            smallest_right.set(i, temp);
            i++;
            j--;
        }
        // iterating through original array, by comparing with greatest left and smallest right to make sure current
        // ele is greater than gratest left and smaller than smallest right at the given position
        for(int k=1; k<arr.length-1; k++){
            if(arr[k]>=greatest_left.get(k) && arr[k]<=smallest_right.get(k)){
                return arr[k];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] ip = {2,1,4,3,6,8,10,7,9};
//        int[] ip = {4, 2, 5, 7};
                int[] ip = {11, 9, 12};

        System.out.println(findElement(ip, ip.length));
    }
}


