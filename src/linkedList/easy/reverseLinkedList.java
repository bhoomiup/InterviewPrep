package linkedList.easy;


public class reverseLinkedList {

//    // Method 1: Iterative
//    public static Node reverseList(Node head) {
//        if(head==null) return null;
//        else if (head.next== null) return head;
//        Node prev = null;
//        Node curr = head;
//
//        while (curr!= null){
//            Node next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
static Node op = null;

    // Method 2: Recursive
    public static Node reverseList(Node head) {
        if(head==null) return null;
        else if (head.next== null) return head;
        helper(null, head);
        return op;

    }

    public static void helper( Node prev, Node curr){
        if(curr== null) {
            op = prev;
            return;
        }
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        helper(prev, curr);
    }


//    public Node reverseList(Node head) {
//        if(head==null || head.next==null) return head;
//        return helper1(null, head);
//    }
//
//    public Node helper1(Node prev, Node curr){
//        if(curr==null) return prev;
//        Node temp = curr.next;
//        curr.next = prev;
//        prev = curr;
//        curr = temp;
//        return helper1(prev, curr);
//    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 4, 5};
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
        head = reverseList(head);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
