package linkedList.easy;
 class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MergeTwoLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode op = new ListNode(0);
        ListNode result = op;
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
