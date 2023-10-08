package array.medium;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int[] op = new int[nums.length];
        int pi = 0;
        int ni = 1;
        for (int num : nums) {
            if (num < 0) {
                op[ni] = num;
                ni += 2;
            } else {
                op[pi] = num;
                pi += 2;
            }
        }
        return op;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

}
