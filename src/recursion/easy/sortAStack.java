package recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class sortAStack {
    public static Stack<Integer> sort (Stack<Integer> st){
        if(st.size()==1) return st;
        int poppedEle = st.pop();
        sort(st);
        insert(st, poppedEle);
        return st;
    }

    public static void insert(Stack<Integer>st, int ele){
        if(st.size()==0 || st.get(st.size()-1)<=ele){
            st.add(ele);
            return;
        }
        int poppedEle = st.pop();
        insert(st, ele);
        st.add(poppedEle);
    }

    public static void main(String[] args) {
        Integer[] st_ip = {1, 5, 0, 2};
        Stack<Integer> ip = new Stack<>();
        Collections.addAll(ip, st_ip);
        sort(ip);
        ip.forEach(System.out::println);
    }

























    public Stack<Integer> sort1(Stack<Integer> s)
    {
        //add code here.
        if(s.size()==0) return s;
        int poppedEle = s.pop();
        sort1(s);
        insert1(s, poppedEle);
        return s;
    }

    public void insert1(Stack<Integer> s, int ele)
    {
        //add code here.
        if(s.size()==0 || s.peek()<=ele) {
            s.add(ele);
            return;
        }
        int poppedEle = s.pop();
        insert(s, ele);
        s.add(poppedEle);
    }
}
