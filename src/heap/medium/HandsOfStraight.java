package heap.medium;

import java.util.HashMap;

public class HandsOfStraight {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i: hand) freq.put(i , 1+freq.getOrDefault(i, 0));

        class Data{
            int freq;
            int val;
            Data(int freq, int val){
                this.freq = freq;
                this.val = val;
            }
        }
        return true;

    }
}
