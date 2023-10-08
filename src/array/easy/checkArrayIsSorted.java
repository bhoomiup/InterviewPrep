package array.easy;

public class checkArrayIsSorted {
    static boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

        // 1752. Check if Array Is Sorted and Rotated
    public boolean check(int[] nums) {
        // 1. get the min ele pos;
        int minEle = Integer.MAX_VALUE;
        int minPos = -1;
        for (int i=0; i< nums.length; i++){
            if (nums[i] < minEle){
                minEle = nums[i];
                minPos = i;
            }
        }

        // 2. if min pos is not 0, it means array is rotated, so if a array is rotated,
        // the 1st ele should be greater than last ele, to maintain it rotated and sorted
        if(minPos!=0 && nums[nums.length-1]<nums[0]) return false;

        // 3. check all the eles to the left of minPos are sorted
        for (int i=1; i< minPos; i++){
            if (nums[i] < nums[i-1]) return false;
        }

        // 4. check all the eles to the right of minPos are sorted
        for (int i=minPos+1; i< nums.length; i++){
            if (nums[i] < nums[i-1]) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        int[] ip= {90, 80, 100, 70, 40, 30};
        System.out.println(arraySortedOrNot(ip, 5));
    }
}
