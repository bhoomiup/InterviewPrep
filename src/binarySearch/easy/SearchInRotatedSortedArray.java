package binarySearch.easy;

public class SearchInRotatedSortedArray {

    static int search(int A[], int l, int h, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        if(A[l]>=A[h]){
            while(l<=h){
                int mid = (l+h)/2;
                if(A[mid]>A[mid+1]){
                    if(key>=A[0] && key<=A[mid]) {
                        l = 0;
                        h = mid;
                    } else {
                        l = mid + 1;
                        h = A.length - 1;
                    }
                    break;
                } else if (A[mid]>A[A.length-1]){
                    l = mid+1;
                } else {
                    h = mid-1;
                }
            }
        }

        while (l<=h){
            int mid = (l+h)/2;
            if(A[mid]==key){
                return mid;
            } else if (A[mid]< key){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {

//        // Method 1:
//        int l = 0;
//        int h = nums.length-1;
//        int m;
//        // 1. find transition at
//        int transitionAt = l;
//        while (l<=h){
//            m=(l+h)/2;
//            if((l>0 && nums[l-1]>nums[l]) ) {
//                transitionAt = l;
//                break;
//            }
//            else if((h<nums.length-1 && nums[h+1]<nums[h])){
//                transitionAt =h+1;
//                break;
//            }
//            else if (nums[l]<=nums[m]) l=m+1;
//            else h=m-1;
//        }
//
//        // 2. find where ele can lie, in left or right half
//        if(target>=nums[transitionAt] && target<=nums[nums.length-1])  {
//            l=transitionAt;
//            h=nums.length-1;
//        }else{
//            l=0;
//            h=transitionAt-1;
//        }
//
//        // 3. do binary search
//        while (l<=h){
//            m=(l+h)/2;
//            if(nums[m]==target) return m;
//            else if (nums[m]>target) h=m-1;
//            else l=m+1;
//        }
//        return -1;

        // Method 2:
        int l = 0;
        int h = nums.length-1;
        int m;

        while (l<=h){
            m = (l+h)/2;
            if(nums[m]==target) return m;
            if(nums[l]<=nums[m]){
                if(target>=nums[l] && target<nums[m]){
                    h=m-1;
                }
                else l=m+1;
            }else {
                if(target>nums[m] && target<=nums[h]){
                    l=m+1;
                }
                else  h=m-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
//        int[] ip =  {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        System.out.println(search(ip, 0, ip.length-1, 10));
//        int[] ip =  {3, 5, 1, 2};
//        System.out.println(search(ip, 0, ip.length-1, 6));
//        int[] ip =  {564,567,571,574,578,583,584,588,591,594,596,604,611,619,622,625,632,637,639,640,642,644,650,652,658,660,663,666,667,668,673,674,678,680,683,686,694,699,709,716,717,719,721,723,727,730,736,761,762,763,775,777,778,784,788,791,794,798,806,814,815,816,821,824,826,828,829,834,840,845,851,852,853,854,857,858,860,861,869,872,876,878,887,889,891,893,899,903,911,913,920,929,931,932,933,934,949,950,953,955,956,957,958,961,963,968,970,971,973,977,978,981,982,983,986,988,990,991,992,998,1000,1,3,9,11,12,16,17,18,20,22,30,31,33,38,40,43,51,53,54,58,63,68,70,72,76,82,84,85,87,88,98,100,101,105,110,113,115,117,123,126,127,128,132,134,135,137,141,142,148,150,153,154,155,156,157,160,161,171,172,173,174,175,180,182,184,185,190,193,196,198,199,200,208,212,217,218,224,225,226,232,239,246,255,264,265,267,270,279,281,282,284,286,287,290,296,297,298,299,301,305,306,309,310,311,314,315,324,326,327,335,338,339,342,344,351,352,353,355,356,359,361,362,365,369,377,378,379,383,384,394,399,400,405,413,416,419,422,425,427,429,434,438,440,446,466,469,470,473,475,476,477,483,484,486,488,490,491,492,495,497,507,512,518,526,529,533,536,538,539,540,542,549,552,553,556,560,563};
//        System.out.println(search(ip, 0, ip.length-1, 281));
        int[] ip =  {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(ip, 0, ip.length-1, 2));
    }
}
