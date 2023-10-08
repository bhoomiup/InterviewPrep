package array.easy;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currOnes = 0;
        for(int num: nums){
            if(num == 1) currOnes++;
            else {
                maxOnes = Math.max(currOnes, maxOnes);
                currOnes = 0;
            }
        }
        maxOnes = Math.max(currOnes, maxOnes);
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] ip = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(ip));
    }
}
