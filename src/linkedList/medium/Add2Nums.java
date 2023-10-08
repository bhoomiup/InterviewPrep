package linkedList.medium;

public class Add2Nums {
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node curr1 = l1;
        Node curr2 = l2;
        int carry = 0;
        Node opHead = null;
        Node opTail = null;
        while(curr1!=null && curr2!=null){
            int sum = (carry+curr1.data+curr2.data);
            Node temp = new Node(((sum)%10));
            if(opHead==null){
                opHead = temp;
                opTail = temp;
            }else {
                opTail.next = temp;
                opTail = temp;
            }
            carry = sum/10;
            curr1 = curr1.next;
            curr2 = curr2.next;
       }
        while(curr1!=null){
            int sum = (carry+curr1.data);
            Node temp = new Node(((sum)%10));
            opTail.next = temp;
            opTail = temp;
            carry = sum/10;
            curr1 = curr1.next;
        }
        while(curr2!=null){
            int sum = (carry+curr2.data);
            Node temp = new Node(((sum)%10));
            opTail.next = temp;
            opTail = temp;
            carry = sum/10;
            curr2 = curr2.next;
        }
        if(carry>0){
            opTail.next = new Node(carry);
        }
        return opHead;
    }




    public ListNode3 addTwoNumbers(ListNode3 l1, ListNode3 l2) {
        int carry = 0;
        ListNode3 op = null;
        ListNode3 opHead = null;
        while (l1!=null && l2!=null){
            int sum = l1.data+l2.data+carry;
            ListNode3 temp = new ListNode3(sum%10);
            carry = sum/10;
            if(op==null) {
                op=temp;
                opHead=temp;
            }
            else {
                op.next = temp;
                op=op.next;
            }
            l1=l1.next;
            l2=l2.next;
        }

        while (l1!=null){
            int sum = l1.data+carry;
            ListNode3 temp = new ListNode3(sum%10);
            carry = sum/10;
            if(op==null){
                op=temp;
                opHead=temp;
            }
            else {
                op.next = temp;
                op=op.next;
            }
            l1=l1.next;
        }

        while (l2!=null){
            int sum = l2.data+carry;
            ListNode3 temp = new ListNode3(sum%10);
            carry = sum/10;
            if(op==null){
                op=temp;
                opHead=temp;
            }
            else {
                op.next = temp;
                op=op.next;
            }
            l2=l2.next;
        }
        if(carry!=0) op.next = new ListNode3(carry);
        return opHead;
    }
    public static void main(String[] args) {
        int[] ip1 = {0};
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
        int[] ip2 = {0};
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
        Node head = addTwoNumbers(head1, head2);
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
