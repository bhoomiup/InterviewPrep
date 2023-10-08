package array.easy;

public class SecondLargestNumberInArray {

    int print2largest(int arr[], int n) {
        // code here
        int firstLargest =-1 , secLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>firstLargest){
                secLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i]<firstLargest && arr[i]>secLargest) {
                secLargest = arr[i];
            }
        }
        return secLargest;

    }
}
