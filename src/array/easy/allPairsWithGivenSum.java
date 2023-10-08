package array.easy;

import java.util.*;

class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

class customComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return (int) (((pair) o1).first- ((pair) o2).first);
    }
}
public class allPairsWithGivenSum {

    static public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here
        HashSet bset = new HashSet<>();
        ArrayList<pair> op =  new ArrayList<>();
        for(long i: B){
            bset.add(i);
        }

        for(long i: A){
            if(bset.contains(X-i)){
                op.add(new pair(i, X-i));
            }
        }

        Collections.sort(op, new customComparator());
        return op.toArray(new pair[0]);
    }

    public static void main(String[] args) {
        long[] ip1 =  {1, 2, 4, 5, 7};
        long[] ip2 =  {5, 6, 3, 4, 8};

        Arrays.stream(allPairs(ip1, ip2, ip1.length, ip2.length, 9)).forEach(x-> {System.out.println(x.first); System.out.println(x.second);});
    }
}
