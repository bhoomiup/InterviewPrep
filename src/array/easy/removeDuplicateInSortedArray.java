package array.easy;

import java.util.Arrays;

public class removeDuplicateInSortedArray {

    static int remove_duplicate(int A[],int N){
        // code here
        int i =0;
        for(int j = 1; j<A.length; j++){
            if(A[i]!=A[j]){
                i++;
                A[i] = A[j];
            }
        }
        return i+1;
    }

    public int removeDuplicates(int[] nums)     {
        int traverse = 1;
        int changeAt = 1;
        int prevEle = nums[0];
        while(traverse!=nums.length){
            if (nums[traverse]>prevEle) {
                prevEle = nums[traverse];
                int temp = nums[changeAt];
                nums[changeAt] = nums[traverse];
                nums[traverse] = temp;
                changeAt++;
            }
            traverse++;
        }
        return changeAt;
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 2, 3, 4, 4, 4, 5, 9, 10};
        System.out.println(remove_duplicate(ip, ip.length));
    }




}
