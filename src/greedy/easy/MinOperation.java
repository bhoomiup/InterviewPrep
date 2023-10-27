package greedy.easy;

public class MinOperation {
    public int minOperation(int n)
    {
        //code here.
        int minOpCount = 0;
        while(n>1){
            if(n%2==1) n-=1;
            else n/=2;
            minOpCount++;
        }
        minOpCount++;
        return minOpCount;
    }
}
