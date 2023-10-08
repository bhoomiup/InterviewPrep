package recursion.easy;

import java.util.Collections;
import java.util.Stack;

public class deleteMidEleInStack {

    public static void delMidEleInStack(Stack<Integer> st, int stSize){
        if(st.size()==(stSize/2)+1){
            st.pop();
            return;
        }
        int poppedEle = st.pop();
        delMidEleInStack(st, stSize);
        st.push(poppedEle);
    }

    public static void main(String[] args) {
        Integer[] st_ip = {1, 5, 0, 2};
//        Integer[] st_ip = {1, 2, 3, 4, 5    };

        Stack<Integer> ip = new Stack<>();
        Collections.addAll(ip, st_ip);
        delMidEleInStack(ip, ip.size());
        ip.forEach(System.out::println);
    }
}
