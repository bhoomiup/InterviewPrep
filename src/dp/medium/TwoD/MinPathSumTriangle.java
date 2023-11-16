package dp.medium.TwoD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinPathSumTriangle {

//    //1. Recursion
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int m = triangle.size()-1;
//        int n = triangle.get(m).size()-1;
//        return helper(0, 0, m, n, triangle);
//    }
//
//    public int helper(int currRow, int currCol, int m, int n,  List<List<Integer>> triangle){
//        if(currRow==m) return triangle.get(currRow).get(currCol);
//        int down = triangle.get(currRow).get(currCol)+helper(currRow+1, currCol, m, n, triangle );
//        int diagonal = triangle.get(currRow).get(currCol)+helper(currRow+1, currCol+1, m, n, triangle );
//        return Math.min(down, diagonal);
//    }
//
//    //2. Memoization
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int m = triangle.size()-1;
//        int n = triangle.get(m).size()-1;
//        List<List<Integer>> dp = new ArrayList<>();
//        for(int i=0; i<=m; i++) dp.add(new ArrayList<>());
//        for(int i=0; i<=m; i++){
//            for(int j=0; j<=triangle.get(m).size(); j++){
//                dp.get(i).add((int) 1e9);
//            }
//        }
//        return helper(0, 0, m, n, dp, triangle);
//    }
//
//    public int helper(int currRow, int currCol, int m, int n,List<List<Integer>> dp,  List<List<Integer>> triangle){
//        if(currRow==m) return triangle.get(currRow).get(currCol);
//        if(dp.get(currRow).get(currCol)!=(int) 1e9) return dp.get(currRow).get(currCol);
//        int down = triangle.get(currRow).get(currCol)+helper(currRow+1, currCol, m, n, dp, triangle );
//        int diagonal = triangle.get(currRow).get(currCol)+helper(currRow+1, currCol+1, m, n, dp, triangle );
//        dp.get(currRow).set(currCol,  Math.min(down, diagonal));
//        return  dp.get(currRow).get(currCol);
//    }

//    //3. Tabulation
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int m = triangle.size()-1;
//        List<List<Integer>> dp = new ArrayList<>();
//        for(int i=0; i<=m; i++) dp.add(new ArrayList<>());
//        for(int i=0; i<=m; i++){
//            for(int j=0; j<=i; j++){
//                if(i==m)  dp.get(i).add(triangle.get(i).get(j));
//                else dp.get(i).add((int) 1e9);
//            }
//        }
//
//        for(int i=m-1; i>=0; i--){
//            for(int j=i; j>=0; j--){
//                int down = triangle.get(i).get(j)+dp.get(i+1).get(j);
//                int diagonal = triangle.get(i).get(j)+dp.get(i+1).get(j+1);
//                dp.get(i).set(j,  Math.min(down, diagonal));
//            }
//        }
//
//        return dp.get(0).get(0);
//    }

    //4. Space Optimization
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size()-1;
        int n = triangle.get(m).size()-1;
        List<Integer> dp = new ArrayList<>();
        for(int i=0; i<=n; i++) dp.add(triangle.get(m).get(i));

        for(int i=m-1; i>=0; i--){
            List<Integer> temp = new ArrayList<>();
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j)+dp.get(j);
                int diagonal = triangle.get(i).get(j)+dp.get(j+1);
                temp.add(Math.min(down, diagonal));
            }
            Collections.reverse(temp);
            dp = temp;
        }

        return dp.get(0);
    }
}
