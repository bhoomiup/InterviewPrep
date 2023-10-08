package basicPatterns;

public class printDaimond {

    static void printDiamond1(int n) {
        // code here
        int start = ((n * 2) - 1) / 2;
        int N = 1;
        while (N <= n) {
            int count = 0;
            for (int x = 0; x < (n * 2) - 1; x++) {
                if (x < start) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                    count++;
                }
                if (count == (N * 2) - 1) break;
            }
            System.out.println();
            start--;
            N++;
        }

        N = n;
        start = 0;
        while(N>0){
            int count = 0;
            for (int x = 0; x < (n * 2) - 1; x++) {
                if (x < start) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                    count++;
                }
                if (count == (N * 2) - 1) break;
            }
            System.out.println();
            start++;
            N--;
        }

    }

    static void printDiamond2(int n) {
        int start = ((n*2)-1)/2;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j = 0; j<=(n*2)-1; j++){
                if(j<start) {
                    System.out.print(" ");
                }
                else{
                    if(i%2==0){
                        if (j%2==0){
                            System.out.print("*");
                            count++;
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    else{
                        if (j%2!=0){
                            System.out.print("*");
                            count++;
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }

                if (count==i+1) break;
            }
            start--;
            System.out.println();

        }

        start = 0;
        for(int i=n-1; i>=0; i--){
            int count = 0;
            for(int j = 0; j<=(n*2)-1; j++){
                if(j<start) {
                    System.out.print(" ");
                }
                else{
                    if(i%2==0){
                        if (j%2==0){
                            System.out.print("*");
                            count++;
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    else{
                        if (j%2!=0){
                            System.out.print("*");
                            count++;
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }

                if (count==i+1) break;
            }
            start++;
            System.out.println();
        }
    }
        public static void main(String[] args) {
//        printDiamond1(5);
        printDiamond2(10);
    }
}
