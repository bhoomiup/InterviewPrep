package array.easy;

import java.util.ArrayList;
import java.util.HashSet;

public class commonElements {
    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here
//        HashSet<Integer> ip2Set = new HashSet<>();
//        HashSet<Integer> ip3Set = new HashSet<>();
//        ArrayList<Integer> op = new ArrayList<>();
//
//        for(int i: B){
//            ip2Set.add(i);
//        }
//
//        for(int j: C){
//            ip3Set.add(j);
//        }
//
//        for(int i: B){
//            if(!ip3Set.contains(i)){
//                ip2Set.remove(i);
//            }
//        }
//
//        for (int k: A){
//            if(ip2Set.contains(k)){
//                if(op.size()==0){
//                    op.add(k);
//                }
//                else{
//                    if(op.get(op.size()-1)!=k){
//                        op.add(k);
//                    }
//                }
//            }
//        }
//        return op;
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> op = new ArrayList<>();
        while(i<A.length && j<B.length && k<C.length){
            if(A[i]==B[j] && A[i]==C[k]){
                if(op.size()>0 && op.get(op.size()-1)!=A[i]){
                        op.add(A[i]);
                    }
                else if (op.size()==0){
                    op.add(A[i]);
                }
                i++;
                j++;
                k++;
            } else if (A[i]<= B[j] && A[i]<= C[k]) {
                i++;
            }else if (B[j]<= A[i] && B[j]<= C[k]) {
                j++;
            }else if (C[k]<= A[i] && C[k]<= B[j]) {
                k++;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int[] ip1 = {1, 5, 10, 20, 40, 80};
        int[] ip2 = {6, 7, 20, 80, 100};
        int[] ip3 = {3, 4, 15, 20, 30, 70, 80, 120};
//        int[] ip1 = {-69,-68,-39,-25,-6,18,33,39,42,46,52,55,55,64,71};
//        int[] ip2 = {-97,-92,-90,-90,-87,-85,-82,-77,-77,-77,-75,-71,-67,-64,-60,-59,-58,-52,-49,-48,-48,-47,-47,-46,-41,-36,-35,-29,-28,-26,-25,-20,-19,-14,-13,-13,-11,-10,-6,-4,2,3,9,12,15,17,20,22,23,24,27,29,36,36,37,38,39,42,45,47,48,48,50,52,52,53,57,59,60,63,63,64,64,65,68,70,71,76,76,77,83,83,84,85,86,89,97,97};
//        int[] ip3 = {-95,-95,-86,-83,-70,-67,-57,-53,-52,-35,-33,-32,-30,-20,-16,-15,-15,-11,-10,-10,-4,0,4,15,18,34,36,37,39,41,43,43,48,49,50,51,58,63,64,67,69,77,79,84,84,94,95,97};
        System.out.println(commonElements(ip1, ip2, ip3, ip1.length, ip2.length, ip3.length));

    }
}
