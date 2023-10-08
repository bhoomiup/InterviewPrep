package sorting.easy;

public class merge2SortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        //1. extra space
//        int[] op = new int[m+n];
//        int i = 0;
//        int j = 0;
//        int opi = 0;
//        while(i<m && j<n){
//            if(nums1[i]<=nums2[j]){
//                op[opi] = nums1[i];
//                i++;
//            } else{
//                op[opi] = nums2[j];
//                j++;
//            }
//            opi++;
//        }
//
//        while(i<m){
//            op[opi] = nums1[i];
//            i++;
//            opi++;
//        }
//
//        while(j<n){
//            op[opi] = nums2[j];
//            j++;
//            opi++;
//        }
//
//        for(int x =0; x<m+n-1;x++ )nums1[x] = op[x];

        // 2. constant space
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
