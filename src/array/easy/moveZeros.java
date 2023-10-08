package array.easy;

public class moveZeros {
    public static void moveZeroes(int[] nums) {
        int changeAt = 0;
        int traverse = 0;
        while (traverse<nums.length){
            if(nums[traverse]!=0){
                int temp = nums[changeAt];
                nums[changeAt] = nums[traverse];
                nums[traverse] = temp;
                changeAt++;
            }
            traverse++;
        }
    }

    public static void main(String[] args) {
        int[] ip = {0,1,0,3,12};
        moveZeroes(ip);
        System.out.println(ip);
    }
}
