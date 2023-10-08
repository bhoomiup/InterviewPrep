package greedy.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Schedule{
    int start;
    int end;
    public Schedule(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class NMeetingsInOneRoom {
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Schedule> s = new ArrayList<>();
        for (int i=0; i<start.length; i++) s.add(new Schedule(start[i], end[i]));
        s.sort(Comparator.comparingInt(o -> o.end));
        int op = 1;
        Schedule prevSch = s.get(0);
        for(int i=1; i<s.size(); i++){
            if(s.get(i).start>prevSch.end) {
                op++;
                prevSch = s.get(i);
            }
        }
        return op;
    }
}
