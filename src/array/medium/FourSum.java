package array.medium;

import java.util.*;

public class FourSum {

    public static  ArrayList<ArrayList<Integer>> fourSum(int[] nums, int k) {
        // code here
        nums = Arrays.stream(nums).sorted().toArray();
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1, m = nums.length - 1;
                while (l < m) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[m];
                    if (sum - k < 0) l++;
                    else if (sum - k > 0) m--;
                    else {
                        ArrayList<Integer> subArr = new ArrayList<>();
                        subArr.add(nums[i]);
                        subArr.add(nums[j]);
                        subArr.add(nums[l]);
                        subArr.add(nums[m]);

                        if (!set.contains(subArr)) op.add(subArr);
                        set.add(subArr);
                        m--;
                    }
                }
            }
        }
        return op;
    }


//    //03-08-2023
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> op = new ArrayList<>();
//        nums = Arrays.stream(nums).sorted().toArray();
//        for (int i=0; i<nums.length; i++){
//            if(i>0 && nums[i]==nums[i-1]) continue;
//            for (int j=i+1; j< nums.length; j++){
//                if(j>i+1 && nums[j]==nums[j-1]) continue;
//                int k = j+1;
//                int l = nums.length-1;
//                while (k<l){
//                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
//                    if(sum==target) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        temp.add(nums[l]);
//                        Collections.sort(temp);
//                        op.add(temp);
//                        k++;
//                        l--;
//                        while (k<l && nums[k]==nums[k-1]) k++;
//                        while (k<l && nums[l]==nums[l+1]) l--;
//                    } else if (sum>target) l--;
//                    else k++;
//                }
//            }
//        }
//        return op;
//
//
//
//    }

    public static void main(String[] args) {
        int[] ip ={88,84,3,51,54,99,32,60,76,68,39,12,26,86,94,39,95,70,34,78,67,1,97,2,17,92,52
        };
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(fourSum(ip,179));
    }
}
