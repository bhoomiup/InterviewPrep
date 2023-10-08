package stack.hard;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class TrappinRainWater {
    public static int trap(int[] height) {

//        // Method 1: using prefix and suffix max
//        int[] rightGreatest = new int[height.length];
//        int maxRight = height[height.length-1];
//        for(int i=height.length-1; i>-1; i--){
//            if(height[i]>maxRight) maxRight = height[i];
//            rightGreatest[i] = maxRight;
//        }
//        int[] leftGreatest = new int[height.length];
//        int maxLeft = height[0];
//        for(int i=0; i<height.length; i++){
//            if(height[i]>maxLeft) maxLeft = height[i];
//            leftGreatest[i] = maxLeft;
//        }
//        int op = 0;
//        for (int i=0; i<height.length;i++){
//            op+=Math.min(leftGreatest[i], rightGreatest[i]) - height[i];
//        }
//        return op;

        // Method 2: 2 pointer method
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int op = 0;
        while (left<=right){
            if(height[left]<=height[right]){
                leftMax = Math.max(leftMax, height[left]);
                op += (leftMax-height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                op += (rightMax-height[right]);
                right--;
            }
        }
        return op;

    }

    public static void main(String[] args) {
        int[] ip = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] ip = {4,2,0,3,2,5};
        System.out.println(trap(ip));
    }
}
