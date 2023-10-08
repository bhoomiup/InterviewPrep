package linkedList.medium;

public class SegregateEvenOdd {

    static Node  divide(Node head){
        // code here
           if (head==null) return null;
           else if(head.next==null || head.next.next==null) return head;
           Node temp1 = head;
           Node temp2 = head.next;
           Node evenHead = temp2;
            while (temp2!=null && temp2.next!=null){
               temp1.next = temp2.next;
               temp2.next = temp2.next.next;
               temp1= temp1.next;
               temp2= temp2.next;
           }
           temp1.next = evenHead;
           return head;
    }

    // segregate indexes
    public ListNode3 oddEvenList(ListNode3 head) {
        if(head==null || head.next ==null || head.next.next==null) return head;
        ListNode3 odd = head;
        ListNode3 even = head.next;
        ListNode3 evenNode = even;
        while (even!=null&&even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenNode;
        return head;
    }

    // segregate values
    public static Node segregateEvenOdd(Node head)
    {
        // Write Your Code Here.
        Node evenHead = null;
        Node even = null;
        Node oddHead = null;
        Node odd = null;
        Node curr = head;
        while (curr!=null){
            if(curr.data%2==0){
                if(evenHead==null) {
                    evenHead = curr;
                    even = curr;
                }else {
                    even.next = curr;
                    even = even.next;
                }
            }else {
                if(oddHead==null) {
                    oddHead = curr;
                    odd = curr;
                }else {
                    odd.next = curr;
                    odd = odd.next;
                }
            }
            curr = curr.next;
        }
        if(evenHead!=null) even.next = oddHead;
        if(oddHead!=null) odd.next = null;
        return evenHead!=null?evenHead:oddHead;

    }
    public static void main(String[] args) {
//        int[] ip = {8, 12, 10, 5, 4, 1, 6};
//        int[] ip = {2,1,3,5,6,4,7};
        int[] ip = {1,2,3,4,5};


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
        head = divide(head);
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
