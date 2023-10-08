package binarySearch.easy;

public class EleThatAppearsOnceInSortedArray {

    static int findOnce(int arr[], int n)
    {
        // Complete this function
        if(arr.length==1) {
            return arr[0];
        }else if(arr[0]!=arr[1]){
            return arr[0];
        } else if (arr[arr.length-1]!=arr[arr.length-2]) {
            return arr[arr.length-1];
        }
        int l = 2;
        int h = arr.length-3;
        while (l<=h){
            int m = (l+h)/2;
            if(arr[m]!=arr[m-1] && arr[m]!=arr[m+1]){
                return arr[m];
            } else if (arr[m]!=arr[m+1]) {
                if((arr.length-(m+1))%2!=0){
                    l=m+1;
                }else {
                    h=m-1;
                }
            } else {
                if(m%2!=0){
                    h=m-1;
                }else {
                    l=m+1;
                }
            }
        }
        return -1;
    }


    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int l = 0;
        int h = nums.length-1;
        int m;
        while (l<=h){
            m = (l+h)/2;
            if(m==0 && nums[m+1]!=nums[0]) return nums[0];
            else if(m==nums.length-1 && nums[m-1]!=nums[m]) return nums[m];
            else if(nums[m+1]!=nums[m] && nums[m-1]!=nums[m]) return nums[m];
            else if (nums[m-1]!=nums[m]) {
                if((m-l)%2==0) l=m+2;
                else h = m-1;
            } else {
                if((h-m)%2==0) h=m-2;
                else l=m+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ip =  {1, 1, 2, 3, 3, 4, 4, 50, 50, 65, 65};
        System.out.println(findOnce(ip, ip.length));
    }
}
