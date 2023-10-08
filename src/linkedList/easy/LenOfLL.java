package linkedList.easy;

public class LenOfLL {
    public static int lengthOfLoop(Node head) {
            // Write your code here
            Node slow = head;
            Node fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast) break;
            }
            int count = 0;
            while (true){
                slow = slow.next;
                count++;
                if(slow==fast) break;
            }
            return count;
    }
}
