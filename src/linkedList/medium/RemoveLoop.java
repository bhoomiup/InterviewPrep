package linkedList.medium;

public class RemoveLoop {

    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node slow = head;
        Node fast = head;
        Node prev;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                Node temp = head;
                while (slow!=temp){
                    prev = slow;
                    slow = slow.next;
                    temp = temp.next;
                }
                prev.next = null;
                return;
            }
        }
        return;
    }
    public static void main(String[] args) {
        int[] ip = {3, 2, 0, -4};
        Node head = null;
        Node tail = null;
        for (int j : ip) {
            if (head == null) {
                head = new Node(j);
                tail = head;
            } else {
                tail.next = new Node(j);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        tail.next = head.next;
        removeLoop(head);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
