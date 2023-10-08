package heap.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}

public class mergeKSortedLinkedList {
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.data));
        for(Node i : arr) pq.add(i);

        Node head = null;
        Node tail = null;
        while (pq.size()!=0){
            Node temp = pq.poll();
            if(head == null) {
                head = temp;
                tail = temp;
            }
            else {
                tail.next = temp;
                tail = temp;
            }
            if(temp.next!=null) pq.add(temp.next);
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
