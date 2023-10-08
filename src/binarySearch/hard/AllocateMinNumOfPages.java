package binarySearch.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateMinNumOfPages {

    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>N) return -1;
        int minPages = Integer.MAX_VALUE;
        int startPages = Arrays.stream(A).min().getAsInt(), endPages = Arrays.stream(A).sum();
        while (startPages<=endPages){
            int currentPages = (startPages+endPages)/2;
            ArrayList<Integer> studentsNMaxPages = maxNumberOfPagesAllocatedForProvidedPages(A, currentPages);
            if(studentsNMaxPages.get(0)<=M) {
                endPages = currentPages-1;
                minPages = Math.min(minPages, studentsNMaxPages.get(1));
            }
            else  {
                startPages = currentPages+1;
            };
        }
        return minPages!=Integer.MAX_VALUE?minPages:-1;
    }

    public static ArrayList<Integer> maxNumberOfPagesAllocatedForProvidedPages(int[] A, int providedPages){
        int maxPages = Integer.MIN_VALUE;
        int currentPages = 0;
        int noOfStudents = 0;

        for(int i: A){
            currentPages += i;
            if(currentPages>=providedPages){
                maxPages = currentPages==providedPages?Math.max(maxPages, currentPages):Math.max(maxPages, currentPages-i);
                currentPages = currentPages==providedPages?0:i;
                noOfStudents++;
            }
        }
        if (currentPages>0){
            maxPages = Math.max(maxPages, currentPages);
            noOfStudents++;
        };
        ArrayList<Integer> op = new ArrayList<>();
        op.add(noOfStudents);
        op.add(maxPages);
        return op;
    }


    public static int findPages1(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(arr.size()<m) return -1;
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i: arr){
            min = Math.max(i, min);
            max+=i;
        }
        int currPages;
        while (min<=max){
            currPages = (min+max)/2;
            if(possibleAllocate(arr, m, currPages)) {
                min = currPages+1;
            }
            else max = currPages-1;
        }
        return min;
    }

    public static boolean possibleAllocate(ArrayList<Integer>arr,int m,int currPages){
        int currSum = 0;
        for (int i: arr){
            currSum+=i;
            if(currSum > currPages){
                m--;
                currSum = i;
                if(m==0)return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(8);
        ip.add(15);
        ip.add(3);
        System.out.println(findPages1(ip, ip.size(), 2));
//        int[] ip = {15, 10, 19, 10, 5, 18, 7};
//        System.out.println(findPages(ip, ip.length, 5));
    }
}
