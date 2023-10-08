package array.easy;

public class IndexOfAnExtraElement {
    public static int findExtra(int a[], int b[], int n) {
        // add code here.
        int l= 0;
        int r = b.length-1;

        if(a[0]!=b[0]){
            return 0;
        }

        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]!=b[mid] && a[mid-1]== b[mid-1]){
                return mid;
            } else if (a[mid]==b[mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return a.length-1;
    }

    public static void main(String[] args) {
//        int a[] = {2,4,6,8,9,10,12};
//        int b[] = {2,4,6,8,10,12};
        int[] a = {3,5,7,9,11,13};
        int[] b = {3,5,7,11,13};
        System.out.println(findExtra(a, b, a.length));
    }
}
