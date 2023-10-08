package linkedList.medium;

public class countLenOfLoop {
    // Method 2: Using Slow Fast Pointer method
    public static int countNodesinLoop(Node head) {
        if (head==null) return 0;
        else if (head.next== head) return 1;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null ){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast) {
                slow = slow.next;
                int len =1;
                while (slow!=fast){
                    slow = slow.next;
                    len++;
                }
                return len;
            };

        }
        return 0;
    }
    public static void main(String[] args) {
        int[] ip = {42, 100, 51, 61, 80, 85, 92, 20, 88, 64};
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
        tail.next = head.next.next.next;
        System.out.println(countNodesinLoop(head));
    }
}
