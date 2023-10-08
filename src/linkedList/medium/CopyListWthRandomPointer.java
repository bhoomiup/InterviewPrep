package linkedList.medium;


 class ListNode3
{
    int data;
    ListNode3 next;
    ListNode3 random;

    ListNode3 prev;
    ListNode3(int data)
    {
        this.data = data;
        this.next = null;
        this.random = null;
        this.prev = null;
    }
}
public class CopyListWthRandomPointer {
    public static ListNode3 copyRandomList(ListNode3 head) {
        if(head==null) return null;

        // create copy and assign to next
        ListNode3 temp = head;
        while (temp!=null){
            ListNode3 newNode = new ListNode3(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        // update the random pointer of new nodes
        ListNode3 prev = head;
        ListNode3 curr = prev.next;
        while (curr.next!=null){
            if(prev.random!=null) curr.random= prev.random.next;
            else curr.random=null;
            prev = curr.next;
            curr = curr.next.next;
        }
        if(prev.random!=null) curr.random= prev.random.next;

        // separate the new and old linked lists
        prev = head;
        curr = prev.next;
        head = curr;
        while (curr.next!=null){
            prev.next = curr.next;
            prev = prev.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

//    public ListNode copyRandomList(ListNode head) {
//        if(head==null) return null;
//        ListNode curr = head;
//        while(curr!=null){
//            ListNode dup = new ListNode(curr.data);
//            dup.next = curr.next;;
//            curr.next = dup;
//            curr = dup.next;
//        }
//        ListNode prev = head;
//        curr = head.next;
//        while (prev!=null){
//            if(prev.random!=null) {
//                curr.random = prev.random.next;
//            }
//            prev = curr.next;
//            if(prev!=null) curr = prev.next;
//        }
//        head = head.next;
//        prev = head;
//        curr = head.next;
//        while (curr.next!=null) {
//            prev.next = curr.next;
//            curr.next = curr.next.next;
//            prev = prev.next;
//            curr = curr.next;
//        }
//        prev.next = null;
//        return head;
//    }

    public static void main(String[] args) {
        int[] ip = {1, 2};
        ListNode3 head = null;
        ListNode3 tail = null;
        for (int j : ip) {
            if (head == null) {
                head = new ListNode3(j);
                tail = head;
            } else {
                tail.next = new ListNode3(j);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        head.random = null;
        tail.random = tail;
        head = copyRandomList(head);
        ListNode3 temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            if (temp.random!=null) System.out.println(temp.random.data);
            temp = temp.next;
           }
    }
}
