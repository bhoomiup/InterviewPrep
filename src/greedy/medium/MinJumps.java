package greedy.medium;

public class MinJumps {

//    // 1. Recursion
//    public static int jump(int[] nums) {
//        int[] op = new int[1];
//        op[0] = Integer.MAX_VALUE;
//        helper(nums, 0, op, 0);
//        return op[0];
//    }
//
//    public static void helper(int[] nums, int index, int[] op, int currJumps){
//        if(index>= nums.length-1) {
//            op[0] = Math.min(op[0], currJumps);
//            return;
//        }
//        for(int i = 1; i<=nums[index] ; i++){
//            helper(nums, index+i, op, currJumps+1) ;
//        }
//    }
//

    // 2. Greedy
    public static int jump(int[] nums) {
        int minJumps = 0;
        int lastJumpIndex = 0;
        int farthestJump = 0;


        for(int i = 0; i<nums.length; i++){
            farthestJump = Math.max(farthestJump, i+nums[i]);
            if(i==lastJumpIndex){
                lastJumpIndex = farthestJump;
                minJumps++;
            }
            if(lastJumpIndex==nums.length-1) return minJumps;
        }
        return minJumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
