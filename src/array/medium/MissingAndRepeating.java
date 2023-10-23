package array.medium;

import java.util.Arrays;

public class MissingAndRepeating {

    static int[] findTwoElement(int arr[], int n) {
        // code here
        int[] op = new int[2];
        for(int i=0; i<arr.length; i++){
            arr[Math.abs(arr[i])-1] = -1*arr[Math.abs(arr[i])-1];
        }
        int temp1 = 0;
        int temp2 = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>0) {
                if (temp1 > 0) temp2 = i+1;
                else temp1 = i+1;
            }
        }

        for(int i: arr){
            if(Math.abs(i)==temp1){
                op[0] = temp1;
                op[1] = temp2;
                return op;
            }
        }
        op[0] = temp2;
        op[1] = temp1;
        return op;
    }




    //28-07-2023
    static int[] findTwoElement1(int arr[], int n) {
        // code here
        int[] op = new int[2];
        for(int i=0; i<n; i++){
            if(arr[Math.abs(arr[i])-1]<0) op[0] = Math.abs(arr[i])-1;
            else arr[Math.abs(arr[i])-1] = -1 * arr[Math.abs(arr[i])-1];
        }
        for(int i=0; i<n; i++)if(arr[i]>0) op[1] = i+1;
        return op;

    }

    public static void main(String[] args) {
        int[] ip = {2,6,3,1,5,3};
//        int[] ip =  {2, 2};
//        int[] ip = {1, 3, 3};
//        int[] ip = {13,33,43,16,25,19,23,31,29,35,10,2,32,11,47,15,34,46,30,26,41,18,5,17,37,39,6,4,20,27,9,3,8,40,24,44,14,36,7,38,12,1,42,12,28,22,45};

        Arrays.stream(findTwoElement1(ip, ip.length)).forEach(c-> System.out.print(c+","));
    }
}
