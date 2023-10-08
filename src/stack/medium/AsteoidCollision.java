package stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteoidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (ast.empty() || ast.peek() * asteroids[i] > 0 || (ast.peek() < 0 && asteroids[i] > 0)) {
                ast.push(asteroids[i]);
            } else {
                while (!ast.empty() && (ast.peek() * asteroids[i] < 0) ){
                    if (Math.abs(ast.peek()) <= Math.abs(asteroids[i])) {
                        ast.pop();
                    }else {
                        break;
                    }
                }
                if (Math.abs(ast.peek()) <= Math.abs(asteroids[i])) {
                    ast.push(asteroids[i]);
                }
            }
        }
        return ast.stream().mapToInt(k -> k).toArray();
    }



















    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i:asteroids){
            if (!s.isEmpty() && ((s.peek()>=0&& i<0))){
                while(!s.isEmpty() && ( (s.peek()>=0&& i<0))){
                    if(Math.abs(s.peek())<=Math.abs(i)) s.pop();
                    else break;
                }
            }
            else s.add(i);
        }

        return s.stream().mapToInt(k->k).toArray();
    }

    public static void main(String[] args) {
//        int[] ip = {10,2,-5};
//        int[] ip = {3, 5, -3};
//        int[] ip = {10, -10};
//        int[] ip = {-2,-2,1,-1};
            int[] ip = {-2,-2,1,-2};

        Arrays.stream(asteroidCollision1(ip)).forEach(System.out::print);
    }
}
