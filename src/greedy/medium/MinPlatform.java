package greedy.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair{
    int time;
    int type;
    Pair(int time, int type){
        this.time = time;
        this.type = type;
    }
}

public class MinPlatform {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        List<Pair> sch = new ArrayList<>();
        for(int i = 0; i<arr.length; i++) {
            sch.add(new Pair(arr[i], 0));
            sch.add(new Pair(dep[i], 1));
        }

        sch.sort((s1, s2) -> {
            if (s1.time < s2.time) return 1;
            else if (s1.time == s2.time) return s1.type - s2.type;
            else return -1;
        });

        int op = 0;
        int curr = 0;
        for(Pair p: sch){
            if(p.type==0) {
                curr++;
                op = Math.max(op, curr);
            }else{
                curr--;
            }
        }
        return op;
    }
}
