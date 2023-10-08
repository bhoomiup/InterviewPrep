package recursion.easy;

public class stringToInt {

    public static int myAtoi(String s) {
        long stringNum = stringToInt(s.length()-1, s, 0, 1);
        if (stringNum > Integer.MAX_VALUE)  return Integer.MAX_VALUE;
        else if (stringNum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)stringNum;
    }
    
    public static long stringToInt(int curr_index,  String ip, long op, long place){
        if (curr_index<0){
            return op;
        }
        if (op>0 && String.valueOf(ip.charAt(curr_index)).equals("-")) op*=-1;
        if (op>0 && !String.valueOf(ip.charAt(curr_index)).equals(" ")) return 0;
        if (Character.isDigit(ip.charAt(curr_index))){
            long temp = place * Long.parseLong((String.valueOf(ip.charAt(curr_index))));
            op+=temp;
            place*=10;
        }
        return stringToInt(curr_index-1, ip, op, place);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi(".1"));
//        System.out.println(myAtoi("-+12"));
    }
}
