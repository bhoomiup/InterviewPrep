package array.medium;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int preProd = 1;
        int postProd = 1;
        int n = nums.length-1;
        for (int i=0; i<nums.length; i++){
            preProd*=nums[i];
            postProd*=nums[n-i];
            maxProd = Math.max(preProd, maxProd);
            maxProd = Math.max(postProd, maxProd);
            if (preProd==0) preProd = 1;
            if (postProd==0) postProd = 1;
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int[] ip = {-2,0,-1};
        System.out.println(maxProduct(ip));
    }
}
