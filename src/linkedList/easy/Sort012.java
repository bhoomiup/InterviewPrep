package linkedList.easy;

public class Sort012 {

    static Node segregate(Node head)
    {
        // add your code here
        Node zero = null;
        Node one = null;
        Node two = null;

        Node zeroHead = null;
        Node oneHead = null;
        Node twoHead = null;

        Node temp = head;
        while (temp!=null){
            if (temp.data==0){
                if(zeroHead==null){
                    zeroHead = temp;
                }else {
                    zero.next = temp;
                }
                zero = temp;
            } else if (temp.data==1){
                if(oneHead==null){
                    oneHead = temp;
                }else {
                    one.next = temp;
                }
                one = temp;
            }else {
                if(twoHead==null){
                    twoHead = temp;
                }else {
                    two.next = temp;
                }
                two = temp;
            }
            temp = temp.next;
        }
        if (zero!=null) {
            if(oneHead!=null) zero.next = oneHead;
            else zero.next = twoHead;
        }
        if (one!=null) one.next = twoHead;
        if (two!=null) two.next = null;
        if(zero==null) {
            if(one==null) return twoHead;
            return oneHead;
        }
        return zeroHead;

    }

    public static void main(String[] args) {

        int[] ip = {2, 2, 1, 2, 1};
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
        head = segregate(head);
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
























}
