package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class longestConsecutiveSubSequence {
    static int findLongestConseqSubseq(int arr[], int N)
    {
        // add your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.add(i);
        }

        int maxLength = 0;
        int min = pq.poll();
        int previousEle = min;

        while(!pq.isEmpty()){
            if(pq.peek()-previousEle>1){
                min = pq.peek();
            }
            previousEle = pq.poll();
            maxLength = Math.max(previousEle-min, maxLength);
        }
        return maxLength+1;
    }






    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 1;
        int currLen = 1;
        for (int num:nums) set.add(num);
        for (int num: nums){
            if(!set.contains(num-1)) {
                System.out.println("num"+ num);
                int temp = num+1;
                while (set.contains(temp)) {
                    currLen+=1;
                    temp+=1;
                }
                System.out.println(currLen);
                maxLen = Math.max(currLen, maxLen);
                currLen=1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int[] ip =  {2,6,1,9,4,5,3};
        int[] ip =  {9,1,4,7,3,-1,0,5,8,-1,6};

//        System.out.println(findLongestConseqSubseq(ip, ip.length));
        System.out.println(longestConsecutive(ip));

    }
}
