package greedy.easy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: bills){
            System.out.println(map);
            if(i!=5){
                int change = i-5;
                while(change>0){
                    if(change%10>0){
                        if(map.get(5)==null) return false;
                        else {
                            map.put(5, map.get(5)-1);
                        }
                    }else{
                        if(map.get(5)!=2 && map.get(10)!=1) return false;
                        else change-=10;
                    }
                }
            }
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
