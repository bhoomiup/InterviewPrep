package array.medium;

public class rowWithMaxOnes {

    static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int maxOnes = -1;
        int row = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i][arr[i].length-1]==0){
                continue;
            } else if (arr[i][0] == 1) {
                return i;
            }
            else{
                int l = 0;
                int r = arr[i].length -1;
                while (l<=r){
                    int mid = (l+r)/2;
                    if(arr[i][mid]==1 && arr[i][mid-1]==0){
                        if(arr[i].length-n+1 > maxOnes){
                            row = i;
                        }
                        break;
                    } else if (arr[i][mid]==0) {
                        l = n+1;
                    } else if (arr[i][mid]==1) {
                        r = n-1;
                    }
                }
            }
        }
        return row;
    }

    public static void main(String[] args) {
        int r = 4;
        int c = 4;
        int[] ip1 = {0, 1, 1, 1};
        int[] ip2 = {0, 0, 1, 1};
        int[] ip3 = {1, 1, 1, 1};
        int[] ip4 = {0, 0, 0, 0};
        int[][] mat = new int[r][c];
        for (int j = 0; j< c; j++){
            mat[0][j] = ip1[j];
        }
        for (int j = 0; j< c; j++){
            mat[1][j] = ip2[j];
        }
        for (int j = 0; j< c; j++){
            mat[2][j] = ip3[j];
        }
        for (int j = 0; j< c; j++){
            mat[3][j] = ip4[j];
        }

        System.out.println(rowWithMax1s(mat, r, c));
    }
}
