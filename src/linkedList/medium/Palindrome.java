package linkedList.medium;

public class Palindrome {

//    //Method 1 : Using Stack
//    public static boolean isPalindrome(Node head) {
//        if (head.next==null) return true;
//        Stack<Integer> firstHalf = new Stack<>();
//        Node slow = head;
//        Node fast = head;
//        while (fast!=null && fast.next != null){
//            System.out.println(slow.data);
//            firstHalf.push(slow.data);
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if(fast != null) slow = slow.next;
//        while (slow!=null){
//            if(slow.data!=firstHalf.pop()) return false;
//            slow = slow.next;
//        }
//        return true;
//
//    }

    //Method 2 : reversing the second half
    public static boolean isPalindrome(Node head) {
        if (head.next==null) return true;

        // find mid
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node prev = slow;
        Node curr = slow.next;
        while (curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // compare 2 half
        Node entry = head;
        while (prev!=entry && prev.next!=entry ){
            if(prev.data!= entry.data) return false;
            entry = entry.next;
            prev = prev.next;
        }

        return prev.data == entry.data;

    }


    public boolean isPalindrome(ListNode3 head) {
        ListNode3 slow = head;
        ListNode3 fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode3 secStart = fast==null?slow:slow.next;
        secStart = reverse(secStart);
        while (secStart!=null){
            if(head.data!=secStart.data) return false;
            head = head.next;
            secStart = secStart.next;
        }
        return true;
    }

    public ListNode3 reverse(ListNode3 head){
        ListNode3 prev = null;
        ListNode3 curr = head;
        while (curr!=null){
            ListNode3 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }























    public static void main(String[] args) {
        int[] ip = {1, 2,  2, 1, 3};
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
        System.out.println(isPalindrome(head));
    }
}
