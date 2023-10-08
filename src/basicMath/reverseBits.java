package basicMath;

public class reverseBits {
    static Long reversedBits(Long X) {
        // code here
        System.out.println(Long.toBinaryString(X));
        String x = Long.toBinaryString(X);
        String y = "";
        for(int i =x.length()-1; i>=0; i--){
            y.concat(String.valueOf(x.charAt(i)));
        }
        System.out.println(Long.getLong(y));
        return Long.getLong(y);
    }

    public static void main(String[] args) {
        System.out.println(reversedBits(100L));
    }
}
