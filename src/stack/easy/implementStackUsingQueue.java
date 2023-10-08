package stack.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class implementStackUsingQueue {
    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();
    public implementStackUsingQueue() {

    }

    // Method 1: extra auxilary queue
//    public void push(int x) {
//        this.q2.add(x);
//        while (this.q1.size()!=0){
//            this.q2.add(this.q1.poll());
//        }
//        this.q1 = this.q2;
//        this.q2 = new LinkedList<>();
//    }

    // Method 2: without extra space
    public void push(int x) {
        this.q1.add(x);
        for(int i =0; i<q1.size()-1; i++){
            this.q1.add(q1.poll());
        }
    }

    public int pop() {
        return this.q1.poll();
    }

    public int top() {
        return this.q1.peek();
    }

    public boolean empty() {
        if (this.q1.size()==0) return true;
        return false;
    }


}
