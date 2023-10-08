package linkedList.easy;

public class Add1ToNumRepAsLL {
    public static Node addOne(Node head)
    {
        //code here.
        head = reverseLL(head);
        Node prev = null;
        Node curr = head;
        int carry = 1;
        while (curr!=null && carry==1){
            int x = curr.data + carry;
            curr.data = x%10;
            carry = x/10;
            prev = curr;
            curr = curr.next;
        }
        if (carry==1){
            prev.next = new Node(1);
        }
        return reverseLL(head);
    }

    public static Node reverseLL(Node head){
        Node prev = null;
        Node curr = head;
        while (curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node addNode(Node head) {
        //code here.
        Node ll = reverse(head);
        int carry = 1;
        Node prev = null;
        Node curr = ll;
        while (carry==1 && curr!=null){
            int x = curr.data + carry;
            curr.data = x%10;
            carry = x/10;
            prev = curr;
            curr = curr.next;
        }
        if(carry!=0) prev.next = new Node(carry);
        return reverse(ll);
    }


    public static Node reverse(Node head){
        if(head.next==null) return head;
        Node prev = null;
        while (head!=null){
            Node temp = head.next;
            head.next=prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] ip = {9};
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
        head = addOne(head);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
