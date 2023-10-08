package stack.basic;

import java.util.LinkedList;
import java.util.Stack;

public class ImpStackUsingLnkedList {
     static class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    //Function to push an integer into the stack.
    void push(int a)
    {
        // Add your code here
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        // Add your code here
        if(top==null) return -1;
        int temp = top.data;
        top = top.next;
        return temp;
    }

    public static void main(String[] args) {
        ImpStackUsingLnkedList s1 = new ImpStackUsingLnkedList();
        s1.push(2);
        s1.push(5);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
}
class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}
class Stack1 {
    //Write your code here
    StackNode head;

    int size;
    Stack1()
    {
        //Write your code here
        head = null;
        size = 0;
    }

    int getSize()
    {
        //Write your code here
        return size;
    }

    boolean isEmpty()
    {
        //Write your code here
        if(size==0) return true;
        return false;
    }

    void push(int data)
    {
        //Write your code here
        if(head==null){
            head  = new StackNode(data);
        }else{
            StackNode temp = new StackNode(data);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void pop()
    {
        //Write your code here
        if(size==0) return;
        else if (size==1) {
            head=null;
        }else {
            StackNode temp = head.next;
            head.next = null;
            head = temp;
        }
        size--;
    }

    int getTop()
    {
        //Write your code here
        if(size==0) return -1;
        return head.data;
    }
}

