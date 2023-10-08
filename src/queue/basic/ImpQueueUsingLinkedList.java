package queue.basic;

import java.util.Queue;

//The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}
public class ImpQueueUsingLinkedList {
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        // Your code here
        QueueNode temp = new QueueNode(a);
        if(front == null) front = rear = temp;
        else {
            rear.next = temp;
            rear = temp;
        }
    }

    //Function to pop front element from the queue.
    int pop()
    {
        // Your code here
        if(front == null) return -1;
        int temp = front.data;
        front = front.next;
        return temp;
    }

    public static void main(String[] args) {
        ImpQueueUsingLinkedList q1 = new ImpQueueUsingLinkedList();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        System.out.println(q1.pop());
        System.out.println(q1.front.data);
    }

}
