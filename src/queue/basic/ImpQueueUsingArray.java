package queue.basic;

public class ImpQueueUsingArray {
    int front, rear;
    int arr[] = new int[100005];

    ImpQueueUsingArray()
    {
        front=0;
        rear=0;
    }

    //Function to push an element x in a queue.
    void push(int x)
    {
        // Your code here
        arr[rear] = x;
        rear++;
    }

    //Function to pop an element from queue and return that element.
    int pop()
    {
        // Your code here
        if(rear==0) return -1;
        int temp = arr[front];
        front++;
        return temp;
    }
}
