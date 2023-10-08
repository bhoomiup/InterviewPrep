package array.medium;

import java.util.*;

public class ThreeSum0 {

    public static List<List<Integer>>  threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        HashSet<List<Integer>> op = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            while (j<k){
                System.out.println("j"+j+"k"+k);
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else {
                    List<Integer> subArr = new ArrayList<>();
                    subArr.add(nums[i]);
                    subArr.add(nums[j]);
                    subArr.add(nums[k]);
                    op.add(subArr);
                    k--;
                }
            }
        }
        return op.stream().toList();
    }




//    // 03-08-2023
//    public List<List<Integer>> threeSum(int[] nums) {
//        HashSet<List<Integer>> op = new HashSet<>();
//        for (int i=0; i<nums.length; i++){
//            HashSet<Integer> thirdEles = new HashSet<>();
//            for (int j=i+1; j< nums.length; j++){
//                int thirdEle = -1*(nums[i]+nums[j]);
//                if(thirdEles.contains(thirdEle)) {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(thirdEle);
//                    Collections.sort(temp);
//                    op.add(temp);
//                }
//                thirdEles.add(nums[j]);
//            }
//        }
//        return op.stream().toList();
//    }

    public static void main(String[] args) {
//        int[] ip = {-1,0,1,2,-1,-4};
        int[] ip = {0,0,0};

        System.out.println(threeSum(ip));
    }
}
