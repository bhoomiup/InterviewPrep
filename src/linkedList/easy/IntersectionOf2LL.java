package linkedList.easy;


import java.util.List;

public class IntersectionOf2LL {

    public static Node getIntersectionNode(Node headA, Node headB) {

        Node curr1 = headA;
        Node curr2 = headB;

        while (curr1 != curr2) {
            if (curr1 == null) {
                curr1 = headB;
                continue;
            } else if (curr2 == null) {
                curr2 = headA;
                continue;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;

        }
        return curr1;
    }

//    public Node getIntersectionNode(Node headA, Node headB) {
//        Node temp1 = headA;
//        Node temp2 = headB;
//        while (true){
//            if(temp1==null|| temp2==null) break;
//            if(temp1==temp2) return temp1;
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//        }
//        if(temp1!=null){
//            Node dummy = headA;
//            while (temp1!=null){
//                temp1 = temp1.next;
//                dummy = dummy.next;
//            }
//            temp1 = dummy;
//            temp2 = headB;
//        }
//
//        else {
//            Node dummy = headB;
//            while (temp2!=null){
//                temp2 = temp2.next;
//                dummy = dummy.next;
//            }
//            temp1 = headA;
//            temp2 = dummy;
//        }
//
//        while (temp1!=temp2) {
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//        }
//        return temp1;
//    }



    public static void main(String[] args) {
        int[] ip1 = {4,1,8,4,5};
        Node head1 = null;
        Node tail1 = null;
        for (int j : ip1) {
            if (head1 == null) {
                head1 = new Node(j);
                tail1 = head1;
            } else {
                tail1.next = new Node(j);
                tail1.next.prev = tail1;
                tail1 = tail1.next;
            }
        }
        int[] ip2 = {1,9,1,2,4};
        Node head2 = null;
        Node tail2 = null;
        for (int j : ip2) {
            if (head2 == null) {
                head2 = new Node(j);
                tail2 = head2;
            } else {
                tail2.next = new Node(j);
                tail2.next.prev = tail2;
                tail2 = tail2.next;
            }
        }
        Node temp = getIntersectionNode(head1, head2);
        assert temp != null;
        System.out.println(temp.data);
    }
}
























