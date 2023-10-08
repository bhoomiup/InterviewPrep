package heap.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq = new PriorityQueue<>();
        maxpq = new PriorityQueue<>(Comparator.reverseOrder());

    }

    public void addNum(int num) {
        if (this.maxpq.size()==this.minpq.size()){
            this.minpq.add(num);
            this.maxpq.add(this.minpq.poll());
        }else {
            this.maxpq.add(num);
            this.minpq.add(this.maxpq.poll());
        }
    }

    public double findMedian() {
        if (this.maxpq.size()==this.minpq.size()) return ((this.maxpq.peek()+this.minpq.peek())/2.0);
        else return this.maxpq.peek();
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        System.out.println(m.findMedian());
        m.addNum(15);
        System.out.println(m.findMedian());
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(8);
        m.addNum(9);
        System.out.println(m.findMedian());
    }
}
