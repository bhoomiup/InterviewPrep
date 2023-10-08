package linkedList.ddl.medium;

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
public class deleteAllK {


        public  Node deleteAllOccurrences(Node head, int k) {
            // Write your code here.
            // Write your code here.
            Node curr = head;
            while (curr!=null){
                Node temp = curr.next;
                if (curr.data==k){
                    if(curr.prev==null && curr.next==null) return null;
                    else if(curr.prev==null) {
                        curr.next.prev = null;
                        head = curr.next;

                    } else if (curr.next==null) {
                        curr.prev.next = null;
                        curr.prev = null;
                    } else {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                        curr.prev = null;
                        curr.next = null;
                    }
                }
                curr = temp;
            }
            return head;
        }

}
