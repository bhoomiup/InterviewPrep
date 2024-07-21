package linkedList.circularLinkedList.medium;

public class winnerOfCircularGame {
    static class Node{
        int val;
        Node next;
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public int findTheWinner(int n, int k) {
        if(n==1) return n;
        if(k==1) return n;

        Node head = new Node(1, null);
        Node tail = head;
        for(int i=2; i<=n; i++){
            Node newNode = new Node(i, null);
            tail.next= newNode;
            tail = newNode;
        }

        tail.next = head;
        Node prev = tail, curr = head;
        int count = 1;
        while(curr.next!=curr){
            if(count==k) {
                prev.next = curr.next;
                count = 1;
            }
            else {
                count++;
                prev = curr;
            }
            curr =  curr.next;
        }
        return curr.val;
    }
    public static void main(String[] args) {
        System.out.println(new winnerOfCircularGame().findTheWinner(6, 5));
    }
}
