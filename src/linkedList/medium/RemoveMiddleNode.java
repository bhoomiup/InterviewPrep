package linkedList.medium;

public class RemoveMiddleNode {

    public static Node deleteMiddle(Node head) {
        if(head.next==null) return null;
        Node prev = null;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next != null){
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }






























    public ListNode3 deleteMiddle(ListNode3 head) {
        if(head.next==null) return null;
        ListNode3 slow = head;
        ListNode3 fast = head;
        ListNode3 prev = null;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
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
        head = deleteMiddle(head);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
