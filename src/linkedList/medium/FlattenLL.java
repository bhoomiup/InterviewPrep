package linkedList.medium;
class CNode {
    public int data;
    public CNode next;
    public CNode child;

    CNode()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    CNode(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    CNode(int data, CNode next, CNode child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

public class FlattenLL {
    public static CNode flattenLinkedList(CNode head) {
        //Write your code here
        CNode curr = head;
        while (curr!=null){
            CNode temp = curr.next;
            CNode lastChild = getLastChild(temp);
            if(lastChild!=null){
                curr.next=curr.child;
                lastChild.next = temp;
            }

            curr = curr.next;
        }
        return head;
    }

    public static CNode getLastChild(CNode parent){
        while (parent.child!=null) parent = parent.child;
        return parent;
    }
}
