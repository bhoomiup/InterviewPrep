package linkedList.medium;


class Node1
{
    int data;
    Node1 next;
    Node1 bottom;

    Node1(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenSortedLL {
    Node1 flatten(Node1 root) {
        // Your code here
        if (root == null || root.next == null) return root;
        Node1 list1 = root;
        Node1 list2 = root.next;
        while (list2 != null) {
            list1 = mergeTwoLists(list1, list2);
            list2 = list2.next;
        }
        return root;
    }


    public Node1 mergeTwoLists(Node1 list1, Node1 list2) {
        Node1 op = new Node1(0);
        Node1 result = op;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                op.bottom = list1;
                op = op.bottom;
                list1 = list1.bottom;
            } else {
                op.bottom = list2;
                op = op.bottom;
                list2 = list2.bottom;
            }
        }

        while (list1 != null) {
            op.bottom = list1;
            op = op.bottom;
            list1 = list1.bottom;
        }


        while (list2 != null) {
            op.bottom = list2;
            op = op.bottom;
            list2 = list2.bottom;
        }
        return result.bottom;
    }

}