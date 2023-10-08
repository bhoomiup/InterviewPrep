package stack.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterEle {

    //Function to find the next greater element for each element of the array.
    public static int[] nextGreaterElements(int[] nums) {
        // Your code here
        int[] op = new int[nums.length];
        Stack<Integer> greaterEleStack = new Stack<>();

        for(int i = 2*nums.length-1; i> -1; i--){
            if(!greaterEleStack.empty()){
                while (!greaterEleStack.empty() & greaterEleStack.peek()<=nums[i%nums.length]){
                    greaterEleStack.pop();
                    if(greaterEleStack.empty()) break;
                }
            }

            if(i<nums.length){
                if(greaterEleStack.empty()) op[i] = -1;
                else {
                    op[i] = greaterEleStack.peek();
                }
            }
            greaterEleStack.push(nums[i%nums.length]);

        }

        return op;
    }












































    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        Stack<Long> s = new Stack<> ();
        for (int i=arr.length-1; i>-1; i--){
            long temp = arr[i];
            while (!s.isEmpty() && s.peek()<= arr[i]) s.pop();
            if(s.empty()) arr[i] = -1;
            else arr[i] = s.peek();
            s.add(temp);
        }
        return arr;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i=nums2.length-1; i>-1; i--){
            while (!s.isEmpty() && s.peek()<= nums2[i]) s.pop();
            map.put(nums2[i], s.peek());
            s.add(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
//        long[] ip = {6, 8, 0, 1, 3};
        int[] ip = {1,2,3,4,3};

        System.out.println(Arrays.toString(nextGreaterElements(ip)));
    }
}
