package stack.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class largestRectangleAreaInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nextSmallest = new int[heights.length];
        int[] prevSmallest = new int[heights.length];

        Stack<Integer> nextSmallestStack = new Stack<>();
        Stack<Integer> prevSmallestStack = new Stack<>();

        for(int i=heights.length-1; i>-1; i--){
            if(nextSmallestStack.empty()) {
                nextSmallest[i] = heights.length;;
                nextSmallestStack.push(i);
            }
            else {
                while (!nextSmallestStack.empty() && heights[nextSmallestStack.peek()]>=heights[i]) nextSmallestStack.pop();
                if(nextSmallestStack.empty()) nextSmallest[i] = heights.length;
                else nextSmallest[i] = nextSmallestStack.peek();
                nextSmallestStack.push(i);
            }
        }
        Arrays.stream(nextSmallest).forEach(System.out::print);
        for(int i=0; i<heights.length; i++){
            if(prevSmallestStack.empty()) {
                prevSmallest[i] = -1;
                prevSmallestStack.push(i);
            }
            else {
                while (!prevSmallestStack.empty() && heights[prevSmallestStack.peek()]>=heights[i]) prevSmallestStack.pop();
                if(prevSmallestStack.empty()) prevSmallest[i] = -1;
                else prevSmallest[i] = prevSmallestStack.peek();
                prevSmallestStack.push(i);
            }
        }
        Arrays.stream(prevSmallest).forEach(System.out::print);

        for(int i=0; i<heights.length; i++){
            maxArea= Math.max(maxArea, heights[i]*((nextSmallest[i]-prevSmallest[i])-1));
        }
        return maxArea;
    }

























    public static int largestRectangleArea1(int[] heights) {
        int[] nextSmallest = findNextSmallest(heights);
        int[] beforeSmallest = findBeforeSmallest(heights);

        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            maxArea = Math.max(maxArea, heights[i]*(nextSmallest[i]-beforeSmallest[i]-1));
        }
        return maxArea;
    }

    public static int[] findNextSmallest(int[] height){
        int[] nextSmallest = new int[height.length];
        Stack<Integer> s = new Stack<>();
        for(int i=height.length-1; i>-1; i--){
            while(!s.isEmpty() && height[s.peek()]>=height[i]) s.pop();
            if(!s.isEmpty()) nextSmallest[i] = s.peek();
            else nextSmallest[i] = height.length;
            s.add(i);
        }
        Arrays.stream(nextSmallest).forEach(x-> System.out.print(x+ " ,"));
        System.out.println();

        return nextSmallest;
    }

    public static int[] findBeforeSmallest(int[] height){
        int[] beforeSmallest = new int[height.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<height.length; i++){
            while(!s.isEmpty() && height[s.peek()]>=height[i]) s.pop();
            if(!s.isEmpty()) beforeSmallest[i] = s.peek();
            else beforeSmallest[i] = -1;
            s.add(i);
        }
        Arrays.stream(beforeSmallest).forEach(x-> System.out.print(x+ " ,"));
        return beforeSmallest;
    }

    public static void main(String[] args) {
//        int[] ip = {6,2,5,4,5,1,6};
//        int[] ip = {7, 2, 8, 9, 1, 3, 6, 5};
//        int[] ip = {2,4};
        int[] ip = {1, 1};
//        int[] ip = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea1(ip));
    }
}
