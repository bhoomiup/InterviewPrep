package array.easy;

import java.util.HashSet;

public class KeyPair {

    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr){
            set.add(i);
        }

        for(int i: arr){
            if(set.contains(x-i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] ip =  {1, 2, 4, 3, 6};
//        System.out.println(hasArrayTwoCandidates(ip, ip.length, 10));
        int[] ip =  {1, 4, 45, 6, 10, 8};
        System.out.println(hasArrayTwoCandidates(ip, ip.length, 16));
    }
}
