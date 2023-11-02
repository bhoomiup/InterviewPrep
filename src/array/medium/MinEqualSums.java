package array.medium;

public class MinEqualSums {
        public static long minSum(int[] nums1, int[] nums2) {
            long sum1 = 0;
            int zero1 = 0;
            long sum2 = 0;
            int zero2 = 0;
            for (int j : nums1) {
                sum1 += j;
                if (j == 0) zero1++;
            }

            for (int j : nums2) {
                sum2 += j;
                if (j == 0) zero2++;
            }

            if(zero1==0 && zero2==0){
                if(sum1==sum2) return sum1;
                else return -1;
            }else if(zero1==0 || zero2==0){
                if(zero1==0 && sum2+zero2>sum1) return -1;
                else if (zero2==0 && sum1+zero1>sum2) return -1;
                else return Math.max(sum1,sum2);
            }else{
                return Math.max(sum1+zero1,sum2+zero2);
            }
        }


    public static void main(String[] args) {
        System.out.println(minSum(new int[]{2,17,23,16,2,0,6,12,10},
                new int [] {19,11,7,16,0}));
    }
}
