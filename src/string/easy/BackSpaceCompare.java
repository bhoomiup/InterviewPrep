package string.easy;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        if(s.length()!=t.length()) return false;
        int i = s.length()-1;
        int j = t.length()-1;
        while (i>=0 || j>=0){
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if(s.charAt(i)!=t.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }

    public static int nextValidIndex(String str, int index){
        int backSpace = 0;
        while(index>=0){
            if(str.charAt(index)=='#') backSpace++;
            else if(backSpace>0) backSpace--;
            else break;
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }
}
