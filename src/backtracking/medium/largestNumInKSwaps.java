package backtracking.medium;

import java.util.Arrays;
import java.util.List;

public class largestNumInKSwaps {
    static String final_op="";
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        final_op = str;
         helper(str.toCharArray(), k, 0);
        return final_op;
    }

    public static void helper(char[] strArray, int k, int index){
        if((String.valueOf(strArray)).compareTo(final_op)>0) final_op = String.valueOf(strArray);
        if(k==0 || index==strArray.length){
            return ;
        }
        helper(strArray, k, index+1);

        for (int i=index+1; i<strArray.length; i++){
            if(strArray[i]> strArray[index]){
                char temp = strArray[index];
                strArray[index] = strArray[i];
                strArray[i] = temp;
                helper(strArray, k-1, index+1);
                temp = strArray[index];
                strArray[index] = strArray[i];
                strArray[i] = temp;

            }

        }

    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum("3435335", 3));
        System.out.println(findMaximumNum("1234567", 4));
        System.out.println(findMaximumNum("4867504573120052493", 3));


    }
}
