package linkedList.basic;

public class DoublyLinkedList {
    Node head;
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data = d;
            prev = null;
            next = null;
        }
    }

    void insertAtHead(int data, DoublyLinkedList doublyLinkedList) {
        Node newNode = new Node(data);
        if(doublyLinkedList.head!=null){
            doublyLinkedList.head.prev = newNode;
            newNode.next = doublyLinkedList.head;
        }
        doublyLinkedList.head = newNode;
    }


    void insertAtTail(int data, DoublyLinkedList doublyLinkedList) {
        Node newNode = new Node(data);
        if(doublyLinkedList.head==null){
            doublyLinkedList.head = newNode;
        }else {
            Node temp = doublyLinkedList.head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }


    void insert(int data, int position,  DoublyLinkedList doublyLinkedList){
        //at head
        if(doublyLinkedList.head==null | position==1){
            insertAtHead(data, doublyLinkedList);
        } else  {
            int pos = 1;
            Node temp = doublyLinkedList.head;
            while (pos<position){
                temp = temp.next;
                pos++;
            }
            //at tail
            if(temp==null){
                insertAtTail(data, doublyLinkedList);
            }else {
                Node newNode = new Node(data);
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev = newNode;
            }

        }
    }

    void delete(int position, DoublyLinkedList doublyLinkedList){
        if(position==1){
            if (doublyLinkedList.head!=null){
                if(doublyLinkedList.head.next!=null){
                    Node temp = doublyLinkedList.head.next;
                    doublyLinkedList.head.next = null;
                    temp.prev = null;
                    doublyLinkedList.head = temp;
                } else {
                    doublyLinkedList.head = null;
                }
            }
        }else{
            int pos = 1;
            Node temp = doublyLinkedList.head;
            while (pos<position){
                temp = temp.next;
                pos++;
            }
            if(temp.next==null){
                temp.prev.next = null;
                temp.prev = null;
            }else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.prev = null;
                temp.next = null;
            }
        }

    }

    void print(DoublyLinkedList doublyLinkedList){
        Node temp = doublyLinkedList.head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(12, dll);
        dll.insertAtHead(13, dll);
        dll.insertAtHead(14, dll);
        dll.insertAtHead(16, dll);
        dll.print(dll);
        dll.insert(17, 5, dll);
        dll.print(dll);
        System.out.println("del");
        dll.delete(3, dll);
        dll.print(dll);
    }
}
