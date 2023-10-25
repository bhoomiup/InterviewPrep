package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test1 {     /*
         *   The class can only be Main
//         */
    static class Student {
        String name;
        int totalMarks;

        Student(String name, int totalMarks) {
            this.name = name;
            this.totalMarks = totalMarks;
        }
    }

    public void main(String[] args) {
        // code here
        // student(name, total marks)
        List<Student> s = new ArrayList<>();
        s.add(new Student("abc", 100));
        s.add(new Student("xyz", 60));
        s.add(new Student("mno", 200));

        Optional<Student> highMarkStudent = s.stream().max(Comparator.comparingInt(u->u.totalMarks));
        System.out.println(highMarkStudent.get().name);
        System.out.println(s.stream().filter(x-> x.name.equals("abc")).findFirst().get());
        s.stream().sorted((x,y)->x.name.compareTo(y.name)).forEach(System.out::println);

        // code here
        // ip = [4, 6, 3, 9, 1]
        // op = [9, 6, 4]
        List<Integer> list = Arrays.asList(10, 23, -4, 0, 18);
        List<Integer> sortedList = list.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println(sortedList);

        System.out.println("test");
    }
}




