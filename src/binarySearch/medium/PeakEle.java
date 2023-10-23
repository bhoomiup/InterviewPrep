package binarySearch.medium;

public class PeakEle {

    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0;
        int h=nums.length-1;
        int m;
        if(nums[1]<nums[0]) return 0;
        if (nums[h-1]<nums[h]) return h;
        l++;
        h--;
        while (l<=h){
            m = (l+h)/2;
            if (nums[m-1]<nums[m] && nums[m+1]<nums[m]) return m;
            else if (nums[m-1]>nums[m]) h = m-1;
            else l = m+1;
        }
        return -1;
    }
}
