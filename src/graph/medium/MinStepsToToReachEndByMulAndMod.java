package graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToToReachEndByMulAndMod {

    static class Pair{
        int node;
        int steps;
        Pair(int node, int steps){
            this.node = node;
            this.steps = steps;
        }
    }
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        int mod = 1000;

        int[] steps = new int[1000];
        Arrays.fill(steps, 1000);
        steps[start] = 0;

        Queue<Pair>  q = new LinkedList<>();
        q.add(new Pair(start, 0));
        while (!q.isEmpty()){
            Pair p = q.poll();
            int currNode = p.node;
            int currSteps = p.steps;
            for(int i: a){
                int newNode = (i*currNode)%mod;
                if(currSteps+1<steps[newNode]){
                    steps[newNode] = (currSteps+1);
                    q.add(new Pair(newNode, steps[newNode]));
                }
            }
        }
        return steps[end]==1000?-1:steps[end];
    }
}
