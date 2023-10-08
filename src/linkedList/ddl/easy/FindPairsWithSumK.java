package linkedList.ddl.easy;

import java.util.ArrayList;

class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
public class FindPairsWithSumK {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        Node tail = head;
        while (tail.next!=null) tail = tail.next;

        while (head.next!=tail.prev){
            int sum = head.data+tail.data;
            if(sum==target) {
                ArrayList<Integer> o = new ArrayList<>();
                o.add(head.data);
                o.add(tail.data);
                op.add(o);
                head = head.next;
                tail = tail.prev;
            }
            else if (sum<target) head = head.next;
            else tail = tail.prev;
        }

        return op;
    }
}
