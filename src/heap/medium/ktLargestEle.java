package heap.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ktLargestEle {
    //Function to return k largest elements from an array.
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i:nums) {
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}
