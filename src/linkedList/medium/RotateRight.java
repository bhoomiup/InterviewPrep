package linkedList.medium;

public class RotateRight {

    public static Node rotateRight(Node head, int k) {
        if (head == null) return null;
        else if (head.next == null) return head;
        int len = len(head);
        if (k== len || k==0) return head;
        int moveRightTill = len-(k%len);
        System.out.println(moveRightTill);
        if(moveRightTill==len || moveRightTill==0) return head;
        int iter = 1;
        Node prev = null;
        Node temp = head;
        Node newTail = null;
        while (temp!= null){
            if(iter==moveRightTill+1) {
                newTail = prev;
            }
            prev = temp;
            temp = temp.next;
            iter++;
        }
        prev.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public static int len(Node head){
        Node temp = head;
        int len = 0;
        while (temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public static ListNode3 rotateRight(ListNode3 head, int k) {
        int count = 1;
        ListNode3 slow = head;
        ListNode3 fast = head;
        while (fast.next!=null){
            fast = fast.next;
            if(count>=k){
                slow=slow.next;
            }
            count++;
        }

        slow.next=null;
        fast.next=head;
        return fast;

    }
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
        head = rotateRight(head, 10);
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
