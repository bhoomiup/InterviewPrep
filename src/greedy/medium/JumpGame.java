package greedy.medium;

public class JumpGame {

    // 1. Recursion
//    public static boolean canJump(int[] nums) {
//        return helper(nums, 0);
//    }
//
//    public static boolean helper(int[] nums, int index){
//        if(index== nums.length-1) return true;
//        for(int i = 1; i<=nums[index]; i++){
//            if(helper(nums, index+i)) return true;
//        }
//        return false;
//    }

    //2. linear
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i=0; i<nums.length; i++){
            if(reachable<i) return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
