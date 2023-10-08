package linkedList.medium;

public class SwapKthNodesFromEnds {

    static Node swapkthnode(Node head, int num, int K)
    {
        // your code here
        if(K>num || head.next==null) return head;
        Node temp = head;
        Node prev = null;
        int iter = 1;
        Node firstPrev = null;
        Node first = head;
        Node secPrev = null;
        Node sec = head;
        while (temp!=null){
            if(iter==K){
                firstPrev = prev;
                first = temp;
            }
            if(iter==num-K+1){
                secPrev = prev;
                sec = temp;
            }
            prev = temp;
            temp = temp.next;
            iter++;
        }
        if (firstPrev!=null) firstPrev.next = sec;
        if (secPrev!=null) secPrev.next = first;
        Node tem = first.next;
        first.next = sec.next;
        sec.next = tem;
        if(K==1) return sec;
        if (K==num) return first;
        return head;
    }

    public ListNode3 reverseKGroup(ListNode3 head, int k) {
        ListNode3 start = head;
        ListNode3 end = head;
        ListNode3 prevEnd = null;
        ListNode3 op = null;
        int count = 1;
        while (end!=null){
            while(count<k && end.next!=null) {
                end=end.next;
                count++;
            }
            if(count<k) break;
            // reverse
            ListNode3 nextnode = end.next;
            ListNode3 temp = reverse(start, end);
            if(prevEnd!=null) {
                prevEnd.next = temp;
            }else op = temp;
            prevEnd =start;
            start = nextnode;
            end = nextnode;
            count =1;
        }
        prevEnd.next=start;
        return op;
    }

    public ListNode3 reverse(ListNode3 start, ListNode3 end){
        ListNode3 prev =null;
        while (true){
            ListNode3 temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
            if(prev==end) break;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] ip = {1,2,3,4};
//        int[] ip = {1, 2, 2, 4, 5, 6, 7, 8};

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
        head = swapkthnode(head, 4, 2);
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
