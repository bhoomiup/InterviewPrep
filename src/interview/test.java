package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        // count occurrence
        String ip = "ilovejavatechie";
        Map<String, Long> mp = Arrays.stream(ip.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mp);

        //find all dups
        HashSet<String> s = new HashSet<>();
        Set<String> ls = Arrays.stream(ip.split("")).filter(x->!s.add(x)).collect(Collectors.toSet());
        System.out.println(ls);

        //find unique
        List<String> uni = mp.entrySet().stream().filter(x->x.getValue()==1).map(y->y.getKey()).collect(Collectors.toList());
        System.out.println(uni);

        //find first occurring unique
        String firstUni = Arrays.stream(ip.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
        System.out.println(firstUni);

        // find 2nd highest
        List<Integer> list = List.of(5, 9, 11, 2, 8, 21, 1);
        Integer nthLargest = list.stream().sorted((x, y)-> y-x).skip(1).limit(1).findFirst().get();
        System.out.println(nthLargest);

        // find longest string
        List<String> strArr = List.of("i", "love", "java", "techie");
        String longest = strArr.stream().reduce((word1, word2)-> word1.length()>word2.length()?word1:word2).get();
        System.out.println(longest);

        // arr containing nums starting with 1
        List<Integer> numStartsWithN = list.stream().map(x-> x+"")
                .filter(y->y.startsWith("1"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numStartsWithN);

        // String join
        String join = String.join(",", strArr);
        System.out.println(join);
    }


}
