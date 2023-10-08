package binarySearch.medium;

import java.util.Arrays;

public class AggressiveCows {

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        if(stalls.length<k) return -1;
        stalls = Arrays.stream(stalls).sorted().toArray();
        int min = 1;
        int max = Arrays.stream(stalls).max().getAsInt();
        int maxMin;
        while (min<=max){
            maxMin = (min+max)/2;
            if(possibleToPlaceCows(stalls, maxMin, k)) min = maxMin+1;
            else max = maxMin-1;
        }
        return max;
    }

    public  static boolean possibleToPlaceCows(int[] stalls,int maxMin,int k){
        System.out.println(maxMin);
        k--;
        int consideredStall=0;
        int i = 1;
        while (i<stalls.length){
            if(stalls[i]<stalls[consideredStall]+maxMin){
                i++; continue;
            }
            k--;
            consideredStall=i;
            if (k==0) return true;
        }
        return k == 0;
    }

    public static void main(String[] args) {
        int[] ip = {18, 27, 44, 77, 69, 19 ,35 ,83, 9 ,64  };
        int k = 4;
        System.out.println(aggressiveCows(ip, k));
    }
}
