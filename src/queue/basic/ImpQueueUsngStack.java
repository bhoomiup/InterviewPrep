package queue.basic;

import java.util.Stack;

//public class ImpQueueUsngStack {
//
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//
//    public ImpQueueUsngStack() {
//
//    }
//
//    public void push(int x) {
//        s1.push(x);
//    }
//
//    public int pop() {
//        if(s1.empty() & s2.empty()) return -1;
//        if(!s2.empty()){
//            return s2.pop();
//        }
//        while (!s1.empty()){
//            s2.push(s1.pop());
//        }
//        return s2.pop();
//    }
//
//    public int peek() {
//        if(s1.empty() & s2.empty()) return -1;
//        if(!s2.empty()){
//            return s2.peek();
//        }
//        while (!s1.empty()){
//            s2.push(s1.pop());
//        }
//        return s2.peek();
//    }
//
//    public boolean empty() {
//        return s1.empty() & s2.empty();
//    }
//
//    public static void main(String[] args) {
//        ImpQueueUsngStack q1 = new ImpQueueUsngStack();
//        q1.push(1);
//        q1.push(2);
//        q1.push(3);
//        System.out.println(q1.peek());
//        System.out.println(q1.pop());
//        System.out.println(q1.peek());
//        System.out.println(q1.pop());
//        q1.push(4);
//        System.out.println(q1.peek());
//    }
//}


//23-08-2023

public class ImpQueueUsngStack {
    Stack<Integer> s;
    Stack<Integer> op;
    public ImpQueueUsngStack() {
        s = new Stack<>();
        op = new Stack<>();
    }

    public void push(int x) {
        s.add(x);
    }

    public int pop() {
        if(s.isEmpty() && op.isEmpty()) return -1;
        if(op.isEmpty()) {
            while (!s.isEmpty()) op.add(s.pop());
        }
        return op.pop();
    }

    public int peek() {
        if(s.isEmpty() && op.isEmpty()) return -1;
        if(op.isEmpty()) {
            while (!s.isEmpty()) op.add(s.pop());
        }
        return op.peek();
    }

    public boolean empty() {
        if(s.isEmpty() && op.isEmpty()) return true;
        return false;
    }
}