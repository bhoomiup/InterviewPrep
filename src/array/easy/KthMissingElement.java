package array.easy;

public class KthMissingElement {

    static int KthMissingElement(int a[], int n, int k)
    {
        // Complete the function
        int count = 0;
        int op = -1;
        for(int i=0; i<a.length-1; i++){
          if(a[i+1]-a[i]>1){
              count++;
              op=a[i]+1;
              if(k==count) return op;
          }
        }
        return op;
    }

    public static void main(String[] args) {
//        int[] ip = {1, 3, 4, 5, 7};
//        System.out.println(KthMissingElement(ip, ip.length, 2));
        int[] ip = {1, 2, 3, 4, 5, 6} ;
        System.out.println(KthMissingElement(ip, ip.length, 2));
    }
}
