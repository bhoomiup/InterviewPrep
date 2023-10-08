package linkedList.medium;

public class ReverseInLoop {
    public static Node reverse(Node node, int k) {
        //Your code here
        int len = 0;
        Node temp = node;
        while (temp!=null) {
            temp = temp.next;
            len++;
        }
        int noOfReverse = len/k;
        Node head = node;
        Node finalHead = node;
        while (noOfReverse>0){
            Node t1 = reverseSubList(head, k);
            if(noOfReverse==k) finalHead = t1;
            head.next = t1.next;
            head = head.next;
            noOfReverse--;
        }
        return finalHead;
    }
    public static Node reverseSubList(Node head, int k){
        Node prev = null;
        Node curr = head;
        while (k>0 && curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
            k--;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] ip = {1, 2, 3, 4, 5, 6};
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
        head = reverse(head, 3);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
