package heap.basic;

public class ArrayRepresentHeap {
    public static boolean countSub(long arr[], long n)
    {
        // Your code goes here
        long n1 = (n/2)-1;
        for(long i=n1; i>=0; i--){
            long li = (2*i)+1;
            long ri = (2*i)+2;
            if(li<n && arr[(int) i] < arr[(int) li]) return false;
            if(ri<n && arr[(int) i] < arr[(int) ri]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        long[] ip = {90, 15, 10, 7, 12, 2};
        long[] ip = {9, 15, 10, 7, 12, 11};

        System.out.println(countSub(ip, ip.length));
    }
}
