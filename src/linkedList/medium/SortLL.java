package linkedList.medium;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
public class SortLL {

    public ListNode2 sortList(ListNode2 head) {
        return mergeSort(head);
    }

    public ListNode2 mergeSort(ListNode2 head) {
        if(head==null||head.next==null) return head;
        ListNode2 mid = null;
        ListNode2 s = head;
        ListNode2 f = head;
        while (f!=null &&f.next!=null){
            mid = s;
            s = s.next;
            f = f.next.next;
        }
        mid.next = null;
        ListNode2 l1 = sortList(head);    //left half recursive call
        ListNode2 l2 = sortList(s);    //right half recursive call

        return mergeTwoLists(l1, l2);
    }

    public ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        ListNode2 op = new ListNode2(0);
        ListNode2 result = op;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                op.next = list1;
                op = op.next;
                list1 = list1.next;
            }else{
                op.next = list2;
                op = op.next;
                list2 = list2.next;
            }
        }

        while(list1!=null){
            op.next = list1;
            op = op.next;
            list1 = list1.next;
        }


        while(list2!=null){
            op.next = list2;
            op = op.next;
            list2 = list2.next;
        }
        return result.next;
    }
}
