package queue.medium;

import java.util.HashMap;
import java.util.Map;

class Node{

    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val, Node next, Node prev){
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
public class LRU {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    public LRU(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0, null, null);
        this.tail = new Node(0, 0, null, head);
        head.next = tail;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node temp = map.get(key);
        temp.next = head.next;
        temp.next.prev = temp;
        temp.prev = this.head;
        this.head.next = temp;
        map.put(key, temp);
        return temp.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key) && map.get(key).val==value) return;
        if(map.size()==capacity) {
            Node temp =  tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;
            temp.next = null;
            temp.prev = null;
            map.remove(temp.key);
            return;
        }
        Node temp = map.getOrDefault(key, new Node(key, value, this.head.next, this.head));
        temp.val = value;
        temp.next = head.next;
        temp.next.prev = temp;
        temp.prev = this.head;
        this.head.next = temp;
        map.put(key, temp);
    }
}
