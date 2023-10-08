package linkedList.medium;

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

public class StartingPointOfLoop {
    // Method 2: Using Slow Fast Pointer method
    public static Node hasCycle(Node head) {
        if (head==null) return null;
        else if (head.next== head) return head;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null ){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast) {
                Node entry = head;
                while (entry!=slow){
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            };

        }
        return null;
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
        System.out.println(hasCycle(head).data);
    }
}
