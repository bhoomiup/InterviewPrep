package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class searchInAMatrix {
    public static int matSearch(int mat[][], int N, int M, int X) {
        // your code here
        ArrayList<Integer> ip = new ArrayList<>();
        for (int[] i : mat) {
            ip.addAll(Arrays.stream(i).boxed().toList());
        }
        int l = 0;
        int r = ip.size() - 1;

        while (l <= r) {
            int n = (l + r) / 2;
            if (ip.get(n) == X) {
                return 1;
            } else if (X < ip.get(n)) {
                r = n - 1;
            } else if (X > ip.get(n)) {
                l = n + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int mat[][] = new int[3][3];
        mat[0][0] = 3;
        mat[0][1] = 30;
        mat[0][2] = 38;
        mat[1][0] = 44;
        mat[1][1] = 52;
        mat[1][2] = 54;
        mat[2][0] = 57;
        mat[2][1] = 60;
        mat[2][2] = 69;

        System.out.println(matSearch(mat, 3, 3, 60));

    }
}
