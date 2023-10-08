package binarySearch.medium;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.

//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
// from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas
// during this hour.

// Return the minimum integer k such that she can eat all the bananas within h hours.

import java.util.Arrays;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int startSpeed = 1;
        int endSpeed = Arrays.stream(piles).max().getAsInt();
        int minSpeed = Integer.MAX_VALUE;
        while (startSpeed<=endSpeed){
            int currentSpeed = (startSpeed+endSpeed)/2;
            if(getHoursToFinish(piles, currentSpeed)<=h){
                minSpeed = Math.min(minSpeed, currentSpeed);
                endSpeed = currentSpeed-1;
            }else {
                startSpeed = currentSpeed + 1;
            }
        }
        return minSpeed;
    }

    public static int getHoursToFinish(int[] piles, int speed){
        int hoursRequiredToFinish = 0;
        for (int i: piles){
            hoursRequiredToFinish += Math.ceil((double) i/speed);
        }
        return hoursRequiredToFinish;
    }


















// 16-08-2023
//    public int minEatingSpeed(int[] piles, int h) {
//
//        int maxBInPiles = Integer.MIN_VALUE;
//        for (int p: piles) maxBInPiles = Math.max(p, maxBInPiles);
//
//        int l1 = 1;
//        int h1 = maxBInPiles;
//        int m1;
//
//        while (l1<h1){
//            m1 = (l1+h1)/2;
//            int noOfHoursReq = noOfHoursReqToEat(piles, m1);
//            if(noOfHoursReq<=h) h1 = m1-1;
//            else l1 = m1+1;
//        }
//        return l1;
//    }
//
//    public int noOfHoursReqToEat(int[] piles, int noOfB){
//        int hours = 0;
//        for(int p: piles)hours+= Math.ceil((double)p/noOfB);
//        return hours;
//    }

    public static void main(String[] args) {
//        int[] ip = {3,6,7,11};
//        System.out.println(minEatingSpeed(ip, 8));
//        int[] ip = {30,11,23,4,20};
//        System.out.println(minEatingSpeed(ip, 5));
        int[] ip = {30,11,23,4,20};
        System.out.println(minEatingSpeed(ip, 6));
    }
}
