package stack.hard;

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //TLE
//        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)-> y-x);
//        int i = 0;
//        int j = 0;
//        while(pq.size()<k) {
//            pq.add(nums[j]);
//            j++;
//        }
//        int[] op = new int[nums.length-k+1];
//        while(j<nums.length){
//            op[i] = pq.peek();
//            pq.remove(nums[i]);
//            pq.add(nums[j]);
//            i++;
//            j++;
//        }
//        op[i] = pq.peek();
//        return op;
//    }

        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int[] op = new int[nums.length-k+1];
        while(j<nums.length){
             while(!dq.isEmpty() && nums[dq.getLast()]<nums[j]) dq.pollLast();
             dq.add(j);
             if(j-i+1==k) {
                 op[i] = nums[dq.getFirst()];
                 if(i==dq.getFirst()) dq.pollFirst();
                 i++;
             }
            j++;
        }
        return op;
    }



    public static void main(String[] args) {
        int[] ip = {1,3,-1,-3,5,3,6,7};
        Arrays.stream(maxSlidingWindow(ip, 3)).forEach(System.out::println);
    }
}
