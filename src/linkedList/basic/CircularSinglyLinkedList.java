package linkedList.basic;

public class CircularSinglyLinkedList {
    Node tail;
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    void insert(Integer element, int data, CircularSinglyLinkedList circularSinglyLinkedList){
        Node newNode = new Node(data);
        if(tail==null){
            newNode.next = newNode;
            tail = newNode;
        }else{
            Node temp = circularSinglyLinkedList.tail;
            while (temp.data != element){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    void delete(int data, CircularSinglyLinkedList csll ){
        // empty list
        if(csll.tail!=null){
            if(csll.tail.next== csll.tail){
                csll.tail= null;
            } else{
                Node temp = csll.tail;
                while (temp.next.data!=data){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                if(temp == temp.next){
                    csll.tail = null;
                }
                // >=2 node
                else if (csll.tail == temp.next) {
                    csll.tail = temp;
                }
                temp.next.next = null;


            }
        }
    }
    void print(CircularSinglyLinkedList csll){
        if(tail!=null){
            Node temp = csll.tail;
            while (temp.next!=tail){
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println(temp.data);
        }

    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insert(null, 5, csll);
        csll.insert(5, 6, csll);
        csll.insert(6, 7, csll);
        csll.insert(7, 8, csll);
        csll.insert(6, 12, csll);
        csll.print(csll);
        csll.delete(8, csll);
        csll.print(csll);

    }
}
