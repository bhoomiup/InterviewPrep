package linkedList.ddl.medium;

public class DeleteDuplicate {
    public static Node uniqueSortedList(Node head) {
        // Write your code here
        if(head==null || head.next==null) return head;
        Node curr = head.next;
        while (curr!=null){
            Node temp = curr.next;
            if (curr.data==curr.prev.data){
                if (curr.next==null) {
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
