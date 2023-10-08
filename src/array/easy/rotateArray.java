package array.easy;

public class rotateArray {

    public static void rotate(int[] nums, int k) {
        if(k> nums.length) k = k%nums.length;
        if (k==0) return;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }


    public static void reverse(int[] arr, int startIndex, int endIndex){
        int i = startIndex;
        int j = endIndex;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] ip = {1,2,3,4,5,6,7};
        rotate(ip, 3);
        System.out.println(ip);
    }
}
