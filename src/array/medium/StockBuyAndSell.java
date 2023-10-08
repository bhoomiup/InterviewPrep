package array.medium;

import java.util.ArrayList;

public class StockBuyAndSell {

    public static void stockBuySell(int[] price, int n) {
        // code here
        int buyDay = 0;
        int currentDay = 1;
        boolean flag = false;
        while(currentDay<price.length){
            if(price[currentDay]<price[currentDay-1]){
                if(buyDay!=currentDay-1){
                    flag =true;
                    System.out.print("(" + buyDay + " " + (currentDay-1)+")" + " ");
                }
                buyDay=currentDay;
            }
            currentDay++;
        }
        if(buyDay!=currentDay-1){
            System.out.print("(" + buyDay + " " + (currentDay-1)+")");
        }
        if (!flag){
            System.out.println("No Profit");
        }

    }



    public int maxProfit(int[] prices) {
        int currSmall = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++){
            maxProfit = Math.max(prices[i] - currSmall, maxProfit);
            currSmall = Math.min(prices[i], currSmall);
        }
        return maxProfit;
    }























    public static void main(String[] args) {
//        int[] ip = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
//        int[] ip = { 100, 180, 260, 310, 40, 535, 695 };
//        int[] ip = {886,2777,6915,7793,8335,5386,492,6649,1421,2362,27,8690,59,7763,3926,540,3426,9172,5736,5211,5368,2567,6429,5782,1530,2862,5123,4067,3135,3929,9802,4022,3058,3069,8167,1393,8456,5011,8042,6229,7373,4421,4919,3784,8537,5198,4324,8315,4370,6413,3526,6091,8980,9956,1873,6862,9170,6996,7281,2305,925,7084,6327,336,6505,846,1729,1313,5857,6124,3895,9582,545,8814,3367,5434,364,4043,3750,1087,6808,7276,7178,5788 };
        int[] ip = {688,7369,7917,9917,6996,3324,7743,9470,2183,8490,5499,9772,6725,5644,5590,7505,8139,2954,9786,7669,8082,8542,8464,197,9507,9355,8804,6348,8611};
        stockBuySell(ip, ip.length);
    }
}
