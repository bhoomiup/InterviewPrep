package array.easy;

public class maximizeNoOfOnes {

    static int findZeroes(int arr[], int n, int m) {
        // code here
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int maxLength = Integer.MIN_VALUE;
        while (j<arr.length){
            if (arr[j] == 0){
                zeroCount++;
            }
            if(zeroCount == m){
                maxLength = Math.max(maxLength, j-i);
            }
            else if(zeroCount > m){
                if(arr[i]==0){
                    zeroCount--;
                }
                i++;
            }
            j++;
        }
        if(maxLength<0 && zeroCount<arr.length){
            return arr.length;
        }
        return maxLength+1;
    }



    public static void main(String[] args) {
        int[] ip = {0,1,1,1,1,0,0,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,0};
        System.out.println(findZeroes(ip, ip.length, 1));
    }
}
