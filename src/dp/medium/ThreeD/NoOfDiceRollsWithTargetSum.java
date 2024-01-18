package dp.medium.ThreeD;

public class NoOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {
        return helper(n, k, target);
    }

    public int helper(int n,int k,int target ){
        System.out.println("n "+n+" k "+k+ " target "+target );
        if (n<0 || k<0 || target<0) return 0;
        if(n==0 && target==0) return 1;
        int count = 0;
        for (int j=k; j>0; j--){
            count+=helper(n-1, j, target-j);
        }
        return count;
    }
}
