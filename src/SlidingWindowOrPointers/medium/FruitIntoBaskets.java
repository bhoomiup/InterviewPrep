package SlidingWindowOrPointers.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
       HashMap<Integer, Integer> fruitsPicked = new HashMap<>();
       int i=0, j=0, maxFruits = 0, currentFruits =0;
       while (j<fruits.length){
           if(fruitsPicked.size()<=2) {
               fruitsPicked.put(fruits[j], fruitsPicked.getOrDefault(fruits[j], 0)+1);
               if (fruitsPicked.size()==2) maxFruits = Math.max(currentFruits, maxFruits);
               currentFruits++;
               j++;
           }
           while (fruitsPicked.size()>2) {
               currentFruits--;
               fruitsPicked.put(fruits[i], fruitsPicked.get(fruits[i])-1);
               if(fruitsPicked.get(fruits[i])==0) fruitsPicked.remove(fruits[i]);
               i++;
           }
           maxFruits = Math.max(currentFruits, maxFruits);

       }
       return maxFruits;
    }


















    // 22-08-2023
    public static int totalFruit1(int[] fruits) {
        int i = 0;
        int j = 0;
        int maxFruits = 0;
        int currFruits = 0;
        HashMap<Integer, Integer> fruitsSet = new HashMap<>();
        while (j<fruits.length){
            if(!fruitsSet.containsKey(fruits[j])) {
                currFruits++;
                fruitsSet.put(fruits[j], 1);
            }else fruitsSet.put(fruits[j], fruitsSet.get(fruits[j])+1);
            j++;
            if (currFruits<=2) maxFruits = Math.max(maxFruits, j-i);
            while (currFruits>2) {
                fruitsSet.put(fruits[i], fruitsSet.get(fruits[i])-1);
                if (fruitsSet.get(fruits[i])==0){
                    fruitsSet.remove(fruits[i]);
                    currFruits--;
                }
                i++;
            }
        }
        return maxFruits;
    }

    public static void main(String[] args) {
//        int[] ip = {1,2,3,2,2};
//        System.out.println(totalFruit1(ip));
//        int[] ip = {0,1,2,2};
//        System.out.println(totalFruit1(ip));
        int[] ip = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit1(ip));
    }
}
