package linkedList.easy;

public class PairwiseSwap {

    public static Node pairwiseSwap(Node head)
    {
        // code here
        if(head.next==null) return head;
        Node prev= null;
        Node first = head;
        Node sec = head.next;

        Node op = head.next;

        while (first.next!=null && sec.next!=null){
            Node temp = first;
            first = sec;
            sec = temp;
            if (prev!=null) prev.next = first;
            Node secNext = first.next;
            first.next = sec;
            sec.next = secNext;
            prev = sec;
            first = sec.next;
            sec = first.next;
        }
        if(sec!=null){
            Node temp = first;
            first = sec;
            sec = temp;
            if (prev!=null) prev.next = first;
            first.next = sec;
            sec.next = null;
        }
        return op;
    }
    public static void main(String[] args) {
        int[] ip = {26,30};
//        int[] ip = {1, 2, 2, 4, 5, 6, 7, 8};

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
        head = pairwiseSwap(head);
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
