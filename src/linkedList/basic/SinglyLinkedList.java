package linkedList.basic;

public class SinglyLinkedList {

    Node head;
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    void insertAtHead(int data, SinglyLinkedList singlyLinkedList){
        Node newNode = new Node(data);
        if (singlyLinkedList.head != null) {
            newNode.next = singlyLinkedList.head;
        }
        singlyLinkedList.head = newNode;
    }

    void insertAtTail(int data, SinglyLinkedList singlyLinkedList){
        Node newNode = new Node(data);
        if (singlyLinkedList.head == null) {
            singlyLinkedList.head = newNode;
        }
        else {
            Node temp = singlyLinkedList.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    void insertAtPosition(int data, int Position, SinglyLinkedList singlyLinkedList){
        Node newNode = new Node(data);
        // if linked list empty
        if(singlyLinkedList.head==null) {
            singlyLinkedList.head = newNode;
        }
        // if insert at head
        else if (Position==1) {
            insertAtHead(data, singlyLinkedList);
        } else {
            Node temp = singlyLinkedList.head;
            int pos = 1;
            while (pos<Position-1){
                temp = temp.next;
                pos++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    void deleteAtPosition(int Position, SinglyLinkedList singlyLinkedList){
        // if head
        if (Position==1) {
            Node temp = singlyLinkedList.head.next;
            singlyLinkedList.head.next = null;
            singlyLinkedList.head=temp;
        } else {
            Node temp = singlyLinkedList.head;
            int pos = 1;
            while (pos<Position-1){
                temp = temp.next;
                pos++;
            }
            // if tail
            if (temp.next.next==null){
                temp.next = null;
            }
            else {
                Node temp1 = temp.next.next;
                temp.next.next = null;
                temp.next = temp1;
            }
        }
    }


    void print(SinglyLinkedList singlyLinkedList){
        Node temp = singlyLinkedList.head;
        while (temp.next!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
//        SinglyLinkedList sll1 = new SinglyLinkedList();
//        sll1.insertAtHead(12, sll1);
//        sll1.insertAtHead(13, sll1);
//        sll1.insertAtHead(14, sll1);
//        sll1.insertAtHead(16, sll1);
//        sll1.print(sll1);
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertAtTail(12, sll2);
        sll2.insertAtTail(13, sll2);
        sll2.insertAtTail(14, sll2);
        sll2.insertAtTail(16, sll2);
        sll2.print(sll2);
        sll2.insertAtPosition(15, 1, sll2);
        sll2.print(sll2);
        sll2.deleteAtPosition(5, sll2);
        sll2.print(sll2);

    }
}

