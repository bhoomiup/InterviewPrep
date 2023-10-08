package greedy.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Pair {
    int value, weight;
    Pair(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {
    public static double maximumValue(Pair[] items, int n, int w) {
        // Write your code here.
        // ITEMS contains {weight, value} pairs.
        List<Pair> temp = Arrays.stream(items).sorted((o1, o2) -> {
            double temp1 = (double) o1.value / o1.weight;
            double temp2 = (double) o2.value / o2.weight;
            if (temp1 < temp2) return 1;
            else if (temp1 > temp2) return -1;
            else return 0;
        }).collect(Collectors.toList());

        double profit = 0;
        for(Pair i : temp){
            if(w-i.weight>=0){
                profit+=i.value;
                w-=i.weight;
                if(w==0) break;
            }else{
                profit+=((double) (i.value*w)/i.weight);
                break;
            }
        }
        return profit;
    }
}
