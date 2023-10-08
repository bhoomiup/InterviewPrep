package binarySearch.medium;

public class PeakEle {

    public int findPeakElement(int[] nums) {
        if(nums.length==1) return nums[0];
        int l=0;
        int h=nums.length-1;
        int m;
        while (l<=h){
            m = (l+h)/2;
            if(m==0 && nums[m+1]<nums[m]) return nums[0];
            else if (m==nums.length-1 && nums[m-1]<nums[m]) return nums[m];
            else if (m>0 && nums[m-1]<nums[m] && nums[m+1]<nums[m]) return nums[m];
            else if (m> 0 && nums[m-1]>nums[m]) h = m-1;
            else l = m+1;
        }
        return -1;
    }
}
