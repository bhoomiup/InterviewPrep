package basicPatterns;

public class printTriangle {
    static void printTriangle(int n) {
        // code here
        int i = 1;
        while(i<=n){
            for(int x = 1; x<=i; x++){
                System.out.print(x + " ");
            }
            System.out.println();
            i++;
        }
    }

    static void printTrianglePyramid(int n) {
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
    }

    public static void main(String[] args) {

    }
}

