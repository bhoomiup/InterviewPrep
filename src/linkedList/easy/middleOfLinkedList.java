package linkedList.easy;


public class middleOfLinkedList {

//    //Method 1: Find len and hen search for mid
//    public static Node middleNode(Node head) {
//        if(head.next== null) return head;
//        int mid = (len(head)/2)+1;
//        Node temp = head;
//        int pos = 0;
//        while (pos<mid-1){
//            temp = temp.next;
//            pos++;
//        }
//        return temp;
//    }
//
//    public static int len(Node head){
//        Node temp = head;
//        int len =0;
//        while (temp.next!=null){
//            len++;
//            temp = temp.next;
//        }
//        return len+1;
//    }
    //Method 2: Slow and Fast pointer,
    // Fast pointer will move double the slow pointer each time till it reaches end
    public static Node middleNode(Node head) {
        if(head.next== null) return head;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 4, 5};
        Node head = null;
        Node tail = null;
        for(int i = 0; i<ip.length; i++){
            if(head == null){
                head = new Node(ip[i]);
                tail = head;
            }
            else {
                tail.next = new Node(ip[i]);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        head = middleNode(head);
        System.out.println(head.data);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
