package recursion.easy;

import java.util.Collections;
import java.util.Stack;

public class reverseStack {

    public static void reverseStack(Stack<Integer> s){
        if(s.size()==0) return;
        int poppedEle = s.pop();
        reverseStack(s);
        pushToLast(s, poppedEle);
    }

    public static void pushToLast(Stack<Integer> st, int ele){
        if(st.size()==0) {
            st.push(ele);
            return;
        }
        int poppedEle = st.pop();
        pushToLast(st, ele);
        st.push(poppedEle);
    }

    public static void main(String[] args) {
        Integer[] st_ip = {1, 5, 0, 2};
//        Integer[] st_ip = {1, 2, 3, 4, 5    };

        Stack<Integer> ip = new Stack<>();
        Collections.addAll(ip, st_ip);
        reverseStack(ip);
        System.out.println(ip);;
    }
}
