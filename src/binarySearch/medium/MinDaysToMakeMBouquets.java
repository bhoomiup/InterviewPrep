package binarySearch.medium;

import java.util.Arrays;

public class MinDaysToMakeMBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        int noOfDays = Integer.MAX_VALUE, startDay = Arrays.stream(bloomDay).min().getAsInt(), endDay = Arrays.stream(bloomDay).max().getAsInt();
        if(m*k>bloomDay.length) return -1;
        while (startDay<=endDay){
            int currentDay = (startDay+endDay)/2;
            int noOfBouquet = noOfBouquetInGivenDays(bloomDay, k, currentDay);
            if(noOfBouquet<m) startDay=currentDay+1;
            else {noOfDays = Math.min(noOfDays,currentDay); endDay=currentDay-1;}
        }
        return noOfDays!=Integer.MAX_VALUE?noOfDays:-1;
    }

    public static int noOfBouquetInGivenDays(int[] bloomDay, int k, int day){
        int noOfBouquet = 0;
        int noOfFlowers = 0;
        for(int i: bloomDay){
            if(i<=day) {
                noOfFlowers++;
                if (noOfFlowers==k){
                    noOfBouquet++;
                    noOfFlowers = 0;
                }
            }else {
                noOfFlowers = 0;
            }
        }
        return noOfBouquet;
    }



    // 17-08-2023
    public static int minDays1(int[] bloomDay, int m, int k) {
        long temp = (long) m*k;
        if(temp>bloomDay.length) return -1;
        int startDay = Integer.MAX_VALUE;
        int endDay = Integer.MIN_VALUE;
        for (int i: bloomDay){
            startDay = Math.min(startDay, i);
            endDay = Math.max(endDay, i);
        }

        int mid;

        while (startDay<=endDay){
            mid = (startDay+endDay)/2;
            if(prepareBouquet(bloomDay, m, k, mid)<=0) endDay=mid-1;
            else startDay = mid+1;
        }

        return startDay;
    }

    public static int prepareBouquet(int[] bloomDay, int m, int k, int mid){
        int flowerInBoq = 0;
        for (int i: bloomDay){
            if(i<=mid){
                flowerInBoq++;
                if (flowerInBoq==k){
                    m--;
                    flowerInBoq=0;
                }
            }else flowerInBoq =0;

        }
        return m;
    }

    public static void main(String[] args) {
        int[] ip = {62,75,98,63,47,65,51,87,22,27,73,92,76,44,13,90,100,85};
        System.out.println(minDays1(ip,2, 7));
//        int[] ip = {1,10,3,10,2};
//        System.out.println(minDays(ip,3,2));
//        int[] ip = {7,7,7,7,12,7,7};
//        System.out.println(minDays(ip,2,3));
//        int[] ip = {1000000000,1000000000};
//        System.out.println(minDays(ip,1,1));
    }
}
