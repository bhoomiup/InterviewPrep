package backtracking.hard;

import java.util.ArrayList;
import java.util.List;

public class palindromcParition {
    static List<List<String>> palindromicPartition(String str)
    {
        // code here
        List<List<String>> op = new ArrayList<>();
        helper(str, 0, new ArrayList<>(), op);
        return op;
    }

    static void helper(String ip, int index, List<String> op, List<List<String>> final_op){
        if(index==ip.length()){
            final_op.add(new ArrayList<>(op));
            return;
        }
        for(int i=index; i<ip.length(); ++i){
                if(isPalindrome(ip.substring(index, i+1))) {
                    op.add(ip.substring(index, i+1));
                    helper(ip, index+1 , op, final_op);
                    op.remove(op.size()-1);
                }
        }
    }

//    static void helper( String s, int index, List < String > path, List < List < String >> res) {
//        if (index == s.length()) {
//            res.add(new ArrayList < > (path));
//            return;
//        }
//        for (int i = index; i < s.length(); ++i) {
//            System.out.println("staet"+index);
//            if (isPalindrome(s.substring(index, i + 1))) {
//                path.add(s.substring(index, i + 1));
//                System.out.println(path);
//                helper(s,i + 1,  path, res);
//                path.remove(path.size() - 1);
//                System.out.println(path);
//
//            }
//        }
//    }


    static boolean isPalindrome(String ip){
        int i = 0;
        while (i<ip.length()){
            if(ip.charAt(i)!=ip.charAt(ip.length()-1-i)) {
                return false;
            }
            i++;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(palindromicPartition("aabb"));
    }
}
