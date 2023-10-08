package linkedList.medium;

public class RemoveNthNodeFromEnd {

//    //Method 1: Traverse 2 times
//    static int getNthFromLast(Node head, int n)
//    {
//        // Your code here
//        int len = 1;
//        Node temp = head;
//        while (temp!=null){
//            temp=temp.next;
//            len++;
//        }
//        Node op = head;
//        if(n>=len) return -1;
//        int i = 1;
//        while (len-i!=n){
//            op = op.next;
//            i++;
//
//        }
//        return op.data;
//    }

    //Method 2: Slow Fast Pointer, move fast pointer  by n time later move slow pointer until fast pointer reaches last node
    static int getNthFromLast(Node head, int n)
    {
        // Your code here
        int count = 1;
        Node slow = head;
        Node fast = head;
        while (fast.next!=null){
            fast = fast.next;
            if(count>=n){
                slow=slow.next;
            }
            count++;
        }
        if (count<n) return -1;

        return slow.data;
    }

    // delete nth node from last
    static Node removeNthFromEnd(Node head, int n)
    {
        // Your code here
        int count = 1;
        Node slow = head;
        Node fast = head;
        while (fast.next!=null){
            fast = fast.next;
            if(count>n){
                slow=slow.next;
            }
            count++;
        }

        // to remove nth node;
        if (count==n) head = head.next;
        else slow.next = slow.next.next;
        return head;
    }


    public ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        ListNode3 slow = null;
        ListNode3 fast = head;
        int count = 1;
        while (count<n){
            fast = fast.next;
            count++;
            if(count==n){
                head = head.next;
                return head;
            }
        }

        while (fast.next!=null){
            if(slow==null) slow=head;
            else slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        int[] ip = {1, 2,  3, 4 ,5, 6, 7, 8, 9};
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
        System.out.println(getNthFromLast(head, 2));
        Node temp = removeNthFromEnd(head, 9);
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
