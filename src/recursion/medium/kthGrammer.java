package recursion.medium;

// We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
//        we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10
public class kthGrammer {

    public static int kthGrammer(int n, int k){
        if(n==1 && k==1) return 0;
        int mid = (int)Math.pow(2, n-1);
        if(k<=mid) return kthGrammer(n-1, k);
        int temp = ((kthGrammer(n-1, k-mid))==0) ?  1: 0;
        return temp;
    }

    // consider n = 4 and k = 5
    //
    //
    //                   ┌── (1)
    //              ┌── (0)
    //              │    └── (0)
    //         ┌── (1) --------------> the parent in (n-2)th row --> 2nd element in 2nd row
    //         │    │    ┌── (0)
    //         │    └── (1) ---------> the parent in (n-1)th row --> 3rd element in 3rd row
    //         │         └── (1) ----> the element we need --------> 5th element in 4th row
    //     ── (0) -------------------> Base case where no more parent
    //         │         ┌── (0)
    //         │    ┌── (1)
    //         │    │    └── (1)
    //         └── (0)
    //              │    ┌── (1)
    //              └── (0)
    //                   └── (0)
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;
        int parent = kthGrammar(n-1, (k+1)/2);
        if(k%2>0) return parent;
        else return 1-parent;
    }
    public static void main(String[] args) {
        System.out.println(kthGrammer(2, 2));
    }
}
