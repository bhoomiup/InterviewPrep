package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternatePosNegELements {
    static void rearrange(int arr[], int n) {
        // code here
        ArrayList<Integer> pos =  new ArrayList<>();
        ArrayList<Integer> neg =  new ArrayList<>();
        for(int i: arr){
            if(i<0){
                neg.add(i);
            }
            else {
                pos.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<pos.size() && j<neg.size()){
            arr[k] = pos.get(i);
            arr[k+1] = neg.get(j);
            i++;
            j++;
            k+=2;
        }

        while(k<n && i<pos.size()){
            arr[k] = pos.get(i);
            i++;
            k++;
        }

        while(k<n && j<neg.size()){
            arr[k] = neg.get(j);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] ip = {9, 4, -2, -1, 5, 0, -5, -3, 2};
//        int[] ip = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(ip, ip.length );
        Arrays.stream(ip).forEach(System.out::print);
    }
}
