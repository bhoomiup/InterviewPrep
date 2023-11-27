package array.medium;

import java.util.Arrays;

public class ReductionOpsToMakeArrayEleEqual {
    public static int reductionOperations(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int count = 0;
        int i=nums.length-1;
        int j=nums.length-2;
        while(j>=0){
            if(nums[j]<nums[j+1]) {
                count+=i-j;
            }
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{1,1,2,2,3}));
    }
}
