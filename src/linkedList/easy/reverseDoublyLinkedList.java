package linkedList.easy;

class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class reverseDoublyLinkedList {
    public static Node reverseDLL(Node  head)
    {
        //Your code here
        Node temp = head;
        while (temp.next!=null){
            Node temNext = temp.next;
            temp.next = temp.prev;
            temp.prev = temNext;
            temp = temNext;
        }
        temp.next = temp.prev;
        temp.prev = null;
        return temp;
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 4, 5};
        Node head = null;
        Node tail = null;
        for(int i = 0; i<ip.length; i++){
            if(head == null){
                head = new Node(ip[i]);
                tail = head;
            }
            else {
                tail.next = new Node(ip[i]);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        head = reverseDLL(head);
        System.out.println(head.data);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
