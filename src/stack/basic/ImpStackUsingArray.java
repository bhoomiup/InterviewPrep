package stack.basic;

//public class ImpStackUsingArray {
//    int top;
//    int arr[] = new int[1000];
//
//    ImpStackUsingArray()
//    {
//        top = -1;
//    }
//
//    //Function to push an integer into the stack.
//    void push(int a)
//    {
//        // Your code here
//        top++;
//        arr[top] = a;
//    }
//
//    //Function to remove an item from top of the stack.
//    int pop()
//    {
//        // Your code here
//        if (top==-1) return -1;
//        int temp = arr[top];
//        top--;
//        return temp;
//    }
//
//
//
//
//
//}

 class Stack {
    int[] stack;
    int top =-1;
    Stack(int capacity) {
        // Write your code here.
        stack = new int[capacity];
        int top = -1;
    }
    public void push(int num) {
        // Write your code here.
        if(top<stack.length-1){
            top++;
            stack[top]=num;
        }
    }
    public int pop() {
        // Write your code here.
        if(top==-1)return -1;
        int temp = stack[top];
        top--;
        return temp;
    }
    public int top() {
        // Write your code here.
        if(top==-1)return -1;
        return stack[top];
    }
    public int isEmpty() {
        // Write your code here.
        if(top==-1) return 1;
        return 0;
    }
    public int isFull() {
        // Write your code here.
        if(top==stack.length) return 1;
        return 0;
    }

     public static void main(String[] args) {
         Stack s = new Stack(2);
         s.push(1);
         s.push(2);
         s.push(3);

     }
}

