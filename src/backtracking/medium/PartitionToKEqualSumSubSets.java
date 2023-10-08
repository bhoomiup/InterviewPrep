package backtracking.medium;

import java.util.Arrays;

public class PartitionToKEqualSumSubSets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%k!=0) return false;
        return helper(Arrays.stream(nums).sorted().toArray(), k, totalSum/k, 0, 0) ;
    }

    public static boolean helper(int[] nums,  int k, int sum, int currSum, int index){
        if (k==1 && index == nums.length) return true;
        if (currSum==sum) return (helper(nums, k-1,sum, 0, 0)) ;
        for(int i=index; i<nums.length; i++){
            if(nums[i]!=-1 && currSum+nums[i]<=sum){
                int temp = nums[i];
                nums[i] = -1;
                if(helper(nums, k,sum, currSum+temp, i+1)) return true;
                nums[i] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] ip = {4,3,2,3,5,2,1};
//        int k = 4;
//        System.out.println(canPartitionKSubsets(ip, k));
//        int[] ip = {1,2,2,2,2};
//        int k = 3;
//        System.out.println(canPartitionKSubsets(ip, k));
        int[] ip = {1,5,11,5};
        int k = 2;
        System.out.println(canPartitionKSubsets(ip, k));

    }
}
