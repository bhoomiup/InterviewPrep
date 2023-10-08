package array.easy;

public class LargestNumberInArray {


    public int largest(int arr[], int n)
    {
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            maxNum = Math.max(maxNum, arr[i]);
        }
        return maxNum;
    }
}
