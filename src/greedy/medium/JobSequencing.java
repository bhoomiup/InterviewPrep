package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequencing {
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[] op = new int[2];
        Arrays.sort(arr, (a1, a2)-> a2.profit-a1.profit);
        int maxDeadLine = Arrays.stream(arr).max(Comparator.comparingInt(a -> a.deadline)).get().deadline;
        int[] jobSeq = new int[maxDeadLine+1];
        for(Job j : arr){
            int deadline = j.deadline;
            while (jobSeq[deadline]!=0 && deadline>0) deadline--;
            if(jobSeq[deadline]==0 && deadline>0) {
                jobSeq[deadline] = j.id;
                op[1]+=j.profit;
                op[0]+=1;
            }
        }
        return op;

    }
}
