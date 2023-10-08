package array.medium;

import java.util.ArrayList;
import java.util.List;

// ele occurs more than n/3 times
public class MajorirtEleII {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> op = new ArrayList<>();
        op.add(-1);
        int count1 = 0;
        int majority_ele1 = nums[0];
        int count2 = 0;
        int majority_ele2 = nums[0];
        for (int num : nums) {
            if (num == majority_ele1) {
                count1++;
            } else if (num == majority_ele2) {
                count2++;
            }else if (count1 == 0) {
                majority_ele1 = num;
                count1++;
            } else if (count2==0) {
                majority_ele2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        System.out.println(majority_ele1);
        System.out.println(majority_ele2);
        validateMajority(nums, op, majority_ele1, majority_ele2);
        return op;
    }

    public static void validateMajority(int[] nums, List<Integer> op, int ele1, int ele2){
        int count1 = 0, count2 = 0;
        for(int num: nums){
            if(num == ele1) count1++;
            else if (num == ele2) count2 ++;
        }
        if (count1>(nums.length/3)) op.set(0, ele1);
        if (count2>(nums.length/3)) op.add(ele2);
    }





//    public List<Integer> majorityElement(int[] nums) {
//        int op1 = Integer.MIN_VALUE, op2 = Integer.MIN_VALUE;;
//        int count1=0, count2=0;
//        for(int i=0; i<nums.length; i++){
//            if(count1==0 && op2!=nums[i]) {
//                op1 = nums[i];
//                count1++;
//            } else if (count2==0 && op1!=nums[i]) {
//                op2 = nums[i];
//                count2++;
//            } else if (op1==nums[i]) count1++;
//              else if (op2==nums[i]) count2++;
//              else {
//                count1--;
//                count2--;
//            }
//        }
//        ArrayList<Integer> op = new ArrayList<>();
//        validateMajorityEle(nums,op1,op2,op);
//        return op;
//
//    }
//
//    public void validateMajorityEle(int[] nums, int num1, int num2, ArrayList<Integer> op){
//        int m = nums.length/3;
//        int count1 = 0, count2= 0;
//        for(int i: nums) {
//            if(i== num1) count1++;
//            else if (i==num2) count2++;
//        }
//        if (count1>m) op.add(num1);
//        if (count2>m) op.add(num2);
//    }

    public static void main(String[] args) {
//        int[] ip = {2,2,1,1,1,2,2,2,1};
//        int[] ip = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        int[] ip = {2,1,1,3,1,4,5,6};

        System.out.println(majorityElement(ip));
    }
}
