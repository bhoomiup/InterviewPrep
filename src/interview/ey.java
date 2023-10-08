package interview;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ey{

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2);
        List<Integer> l2 = List.of(3, 4);

        List<List<Integer>> op = l1.stream()
                .flatMap(e1 -> l2.stream().map(e2 -> List.of(e1, e2)))
                .collect(Collectors.toList());
        System.out.println(op);
    }


}