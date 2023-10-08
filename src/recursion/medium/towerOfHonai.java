package recursion.medium;

public class towerOfHonai {

    static long count = 0;

    public static long toh(int N, int from, int to, int aux) {
        count++;
        // Your code here
        if(N==1) {
            System.out.println(String.format("move disk %s from rod %s to rod %s", N, from, to)) ;
            return count;
        }
        toh(N-1, from, aux, to);
        System.out.println(String.format("move disk %s from rod %s to rod %s", N, from, to));
        toh(N-1,aux, to, from);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(toh(3, 1, 3, 2));
    }
}
