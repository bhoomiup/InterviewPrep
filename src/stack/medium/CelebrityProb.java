package stack.medium;

import java.util.Stack;

public class CelebrityProb {
    static int celebrity(int M[][], int n)
    {
        // code here

        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++) s.add(i);

        while (s.size()>1)
        {
            int a = s.pop();
            int b = s.pop();
            if(M[a][b]==1) s.add(b);
            else s.add(a);
        }
        int posCeleb = s.peek();
        for(int i = 0; i<n ; i++){
            if(M[posCeleb][i]==1) return -1;
        }

        for (int i = 0; i<n ; i++){
            if(posCeleb!=i && M[i][posCeleb]==0) return -1;
        }
        return posCeleb;
    }

    public static void main(String[] args) {
       int[][] M= {{0 ,1, 0}, {0, 0, 0}, {0, 1, 0}};
       celebrity(M, M.length);
    }
}
