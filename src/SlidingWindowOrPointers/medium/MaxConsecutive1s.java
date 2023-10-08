package SlidingWindowOrPointers.medium;

public class MaxConsecutive1s {

    public static int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int zeroCount = 0;
        int i = 0;
        int j = 0;

        while(j<nums.length){

            if (zeroCount<=k){
                if (nums[j]==0) zeroCount++;
                if (zeroCount<=k) maxOnes = Math.max(maxOnes, j+1-i);
                j++;
                continue;
            }

            while (zeroCount>k){
                if(nums[i]==0) zeroCount--;
                i++;
            }
        }
        return maxOnes;
    }
















    // 22-08-2023
    public static int longestOnes1(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxOnes = Integer.MIN_VALUE;
        int currZeros = 0;
         while (j<nums.length){
             if(currZeros<=k){
                 if(nums[j]==0) currZeros++;
                 j++;
                 if (currZeros<=k) maxOnes = Math.max(maxOnes, j-i);
                 System.out.println(maxOnes);
             }
             while (currZeros>k) {
                 System.out.println("i "+i);
                 if(nums[i]==0){
                     currZeros--;
                 }
                 i++;
             }
         }
         if(currZeros==k) maxOnes = Math.max(maxOnes, j-i);
         return maxOnes;
    }
    public static void main(String[] args) {
        int[] ip = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes1(ip, 3));
//        int[] ip = {1,1,1,0,0,0,1,1,1,1,0};
//        System.out.println(longestOnes1(ip, 2));
    }
}
