package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                inDegrees[i]--;
                if(inDegrees[i]==0) q.add(i);
            }
        }
        return op.size()==numCourses;
    }
}
