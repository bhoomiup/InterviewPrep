package linkedList.easy;

public class DeleteWithoutHeadPointer {

    void deleteNode(Node del)
    {
        // Your code here
        del.data = del.next.data;
        del.next = del.next.next;
        del.next.next = null;
    }
}
