package linkedList.ddl.easy;

public class ReverseDLL {

    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        Node prev = null;
        while (head!=null){
            Node temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
