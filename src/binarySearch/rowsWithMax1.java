package binarySearch;

public class rowsWithMax1 {

    static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int row = 0;
        int col = arr[0].length-1;
        int op = -1;
        while(row<arr.length && col>-1){
            if(arr[row][col]==1) {
                col--;
                op = row;
            } else row++;
        }
        return op;

    }

    public static void main(String[] args) {
        int[][] ip = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(ip, ip.length, ip[0].length));
    }
}
