package graph.medium;

import graph.basic.DFS;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        DFS(image, sr, sc, image[sr][sc] , color);
        return image;
    }

    public static void DFS(int[][] image, int sr, int sc, int preColor, int color){
        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[sr].length-1 || image[sr][sc]!=preColor || image[sr][sc]==color) return ;
        int temp = image[sr][sc];
        image[sr][sc] = color;
        DFS(image,  sr, sc-1, temp, color);
        DFS(image, sr-1, sc, temp, color);
        DFS(image,  sr, sc+1, temp, color);
        DFS(image,sr+1, sc, temp, color);
    }

    public static void main(String[] args) {
        int[][] ip ={{1,1,1},{1,1,0},{1,0,1}};
        floodFill(ip, 1, 1, 2);
        Arrays.stream(ip).forEach(x-> Arrays.stream(x).forEach(y-> System.out.println(y+ " ")));
    }
}
