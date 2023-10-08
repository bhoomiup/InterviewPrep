package binarySearch.hard;

public class medianOf2SortedArrayOfDifferentSizes {

    static double medianOfArrays(int n, int m, int a[], int b[])
    {
        if (n>m) return medianOfArrays(m, n, b, a);
        if (n==0 && m==0) return 0.0;
        else if(n==0) return m%2==0? (b[(m/2)-1]+b[(m/2)])/2.0:b[m/2];
        int partitionCount = (n+m)%2==0?(n+m)/2:(n+m+1)/2;
        int partitionStart = 0;
        int partitionEnd = n;
        while (partitionStart<=partitionEnd){

            int cut1 = (partitionStart+partitionEnd)/2;
            int cut2 =  partitionCount-(cut1);

            int l1 = cut1>0? a[cut1-1]:0;
            int r1 = cut1<n? a[cut1]:Integer.MAX_VALUE;
            int l2 = cut2>0? b[cut2-1]:0;
            int r2 = cut2<m?b[cut2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1) {
                return (n+m)%2==0?(Math.max(l1,l2)+Math.min(r1, r2))/2.0:Math.max(l1,l2);
            }
            else if (l1>r2) partitionEnd = cut1-1;
            else partitionStart = cut1+1;
        }
        return 0.0;
    }

    static double medianOfArrays1(int n, int m, int a[], int b[])
    {
        //always do BS on shorter array, means we will try to pick eles from shorter array, improves TC
        if(n>m) return medianOfArrays1(m, n, b, a);
        int leftPartOfMedian = ((n+m)/2)+1;
        //define parttion on smaller array, i.e a
        int partitionStart = 0;
        int partitionEnd = n;
        while (partitionStart<=partitionEnd){
            int cutOn1 = (partitionStart+partitionEnd)/2;
            int cutOn2 = leftPartOfMedian-cutOn1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int h1 = Integer.MAX_VALUE;
            int h2 = Integer.MAX_VALUE;
            if(cutOn1-1>=0) l1=a[cutOn1-1];
            if(cutOn1<n) h1=a[cutOn1];
            if(cutOn2-1>=0) l2=b[cutOn2-1];
            if(cutOn2<n) h2=b[cutOn2];
            if(l1<=h2 && l2<=h1){
                return (n+m)%2==0? (Math.max(l1, l2) + Math.min(h1, h2))/2.0 : (double) Math.max(l1, l2);
            } else if (l1>h2) partitionEnd= cutOn1-1;
            else partitionStart=cutOn1+1;
        }
        return 0;
    }


    public static void main(String[] args) {
//        int[] a = {1,5,9};
//        int[] b = {2,3,6,7};
//        int[] a = {4,6};
//        int[] b = {1,2,3,5};
//        int[] a = {2, 3};
//        int[] b = {};
//        int[] a = {1};
//        int[] b = {1};
//        int[] a = {};
//        int[] b = {1, 2};
//        int[] a = {48425, 53237, 53652, 83052, 96283};
//        int[] b = {3034};
//        int[] a = {8207,8732,13064,25097,31081,33062,33356,35526,37049,37841,43090,44913,47030,47290,77969,80386,82387,82398,84309,86102,91432,94428,95825};
//        int[] b = {1468,2485,2950,4687,4896,5264,5399,7473,8042,9115,10239,10305,11826,15929,16800,17640,17733,18178,19549,22726,23237,23766,24892,28131,28328,30786,30994,31966,32711,32790,33399,34487,34939,35421,36983,39289,42976,43119,44679,45129,45964,46423,49485,49631,49799,51271,51695,52711,55109,55403,55437,56899,57122,60279,65043,66249,66570,67067,68333,69890,72776,74979,74997,75472,76841,77811,79954,80366,82354,84579,86190,86518,86703,88068,88573,92517,93840,94303,96167,96377,96408,98116,99051,99640};
        int[] a = {93,526,3568,4072,4403,4647,4660,5728,5934,6084,8108,9522,12056,14224,14619,15431,17213,17643,19256,19981,21590,22227,22602,23188,24508,24956,25317,28441,33324,34421,34957,35657,36211,40208,40445,41207,44057,44824,46381,46741,47173,47774,48415,48807,51004,52510,53819,54925,57232,58403,59259,60163,63280,63658,63831,65921,69538,71211,72224,74165,74845,75597,76614,76674,76760,78499,81094,81478,82768,82776,84376,87092,88675,89373,91266,96147,99042,99345,99450};
        int[] b = {};
        System.out.println(medianOfArrays(a.length, b.length,a,b));

    }
}
