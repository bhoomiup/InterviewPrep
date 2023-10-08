package stack.medium;

import java.util.Stack;

public class MinStack {

    long minEle = Long.MAX_VALUE;
    Stack<Long> stack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        long longval = val;
        if(stack.empty()){
            stack.push(longval);
            minEle = val;
        } else if (val<minEle) {
            stack.push(2*longval-minEle);
            minEle = val;
        } else {
            stack.push(longval);
        }
    }

    public void pop() {
        if(stack.empty()){
            return ;
        } else if (stack.peek()<minEle) {
            minEle = 2*minEle-stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        if(stack.empty()){
            return -1;
        } else if (stack.peek()<minEle) {
            return  (int)minEle;
        }
        return Math.toIntExact((stack.peek()));
    }

    public int getMin() {
        if(stack.empty()) return -1;
        return (int) minEle;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
