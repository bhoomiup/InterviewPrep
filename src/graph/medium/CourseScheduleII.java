package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] i: prerequisites) adj.get(i[1]).add(i[0]);

        // prepare inDegree
        int[] inDegrees = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int j: adj.get(i)){
                inDegrees[j]++;
            }
        }

        List<Integer> op = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length; i++ )if (inDegrees[i]==0) q.add(i);
        while (!q.isEmpty()){
            int temp = q.poll();
            op.add(temp);
            for (int i: adj.get(temp)){
                System.out.println(i);
                inDegrees[i]--;
                if(inDegrees[i]==0) q.add(i);
            }
        }
        if(op.size()==numCourses) return new int[0];
        int[] op1 = new int[op.size()];
        for(int i = 0; i < op.size(); i++) op1[i] = op.get(i);
        return op1;
    }
}
