package array.medium;

// Ele occurs more than n/2 times
public class MajorityEle {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority_ele = nums[0];
        for (int num : nums) {
            if (count == 0) {
                majority_ele = num;
                count++;
                continue;
            }
            if (num == majority_ele) count++;
            else count--;
        }
        return majority_ele;
    }

    public static void main(String[] args) {
        int[] ip = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(ip));
    }
}
