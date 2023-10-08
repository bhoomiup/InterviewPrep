package binarySearch.medium;

import java.util.Arrays;

public class capacityToShipPackagesInGivenDays {
    public static int shipWithinDays(int[] weights, int days) {
        int startWeight = Arrays.stream(weights).max().getAsInt();
        int endWeight = Arrays.stream(weights).sum();
        int minBoatCapacity = Integer.MAX_VALUE;
        while (startWeight<=endWeight){
            int currentWeight = (startWeight+endWeight)/2;
            int daysToShip = calcNoOfDaysToShip(weights, currentWeight);
            if(daysToShip<=days){
                minBoatCapacity = Math.min(minBoatCapacity, currentWeight);
                endWeight = currentWeight-1;
            } else {
                startWeight = currentWeight+1;
            }
        }
        return minBoatCapacity;
    }

    public static int calcNoOfDaysToShip(int[] weights, int capacityOfBoat){
        int days = 0;
        int weightPerDay = 0;
        int i = 0;
        System.out.println("cap"+capacityOfBoat);
        while (i<weights.length){
            weightPerDay+=weights[i];
            if(weightPerDay==capacityOfBoat) {
                weightPerDay=0;
                days++;
            } else if(weightPerDay>capacityOfBoat){
                weightPerDay = weights[i];
                days++;
            }
            i++;
        }
        if(weightPerDay>0) days++;
        System.out.println(days);
        return days;
    }







    public static int shipWithinDays1(int[] weights, int days) {
        int minW = Arrays.stream(weights).max().getAsInt();
        int maxW = Arrays.stream(weights).sum();
        int currW;
        while (minW<=maxW){
            currW = (minW+maxW)/2;
            if (getDaysForWeight(weights, currW, days)>=0)  {
                minW = currW+1;
            }
            else   maxW = currW-1;
        }
        return minW;
    }

    public static int getDaysForWeight(int[] weights, int currW, int days){
        System.out.println("c"+currW);
        int tempW = 0;
        for (int i: weights){
            tempW+=i;
            if(tempW>=currW){
                days--;
                if(tempW>currW) tempW = i;
                else tempW = 0;
            }
        }
        if(tempW>0) days--;
        System.out.println(days);
        return days;
    }


















    public static void main(String[] args) {
        int[] ip = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays1(ip, 5));
//        int[] ip = {3,2,2,4,1,4};
//        System.out.println(shipWithinDays(ip, 3));
//        int[] ip = {1,2,3,1,1};
//        System.out.println(shipWithinDays(ip, 4));
    }
}
