package recursion.basic;

public class checkPalindrome {

    public static boolean isPalindrome(String str){
        return checkPalindrome(0, str.length()-1, str);
    }

    public static boolean checkPalindrome(int left, int right, String str){
        if(left>=right){
            return true;
        }
        if(str.charAt(left) != str.charAt(right)) return false;
        return checkPalindrome(left+1, right-1, str);
    }
    public static double myPow(double x, int n) {
        System.out.println(n);
        if(n==1) return x;
        int firstPow = n/2;
        int secPow = n/2+ (n%2);
        return myPow(x, firstPow) * myPow(x, secPow);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("rhar"));
//        System.out.println(isPalindrome("abba"));
        System.out.println(myPow(2.0, 10));
    }
}
