package linkedList.easy;

import java.util.HashSet;
import java.util.List;

public class DetectLoop {
//    // Method 1: Usn HashSet
//    public static boolean hasCycle(Node head) {
//        if (head==null) return false;
//        HashSet<Node> nodes = new HashSet<>();
//        nodes.add(head);
//        Node temp = head;
//        while (temp.next!=null){
//            nodes.forEach(x-> System.out.println(x.data));
//            temp = temp.next;
//            System.out.println(temp.data);
//            if (nodes.contains(temp)) return true;
//            nodes.add(temp);
//
//        }
//        return false;
//    }
    // Method 2: Using Slow Fast Pointer method
    public static boolean hasCycle(Node head) {
        if (head==null) return false;
        else if (head.next== head) return true;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null ){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast) return true;

        }
        return false;
    }
    public static void main(String[] args) {
        int[] ip = {1};
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
        System.out.println(hasCycle(head));
    }
}
