package cn.zou.test.test_lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestLambda {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("邹文豪",12), new Student("中午", 14));
        list.forEach(System.out::println);

        // Predicate
        List languages = Arrays.asList("Java","Scala","C++","Haskell","Lisp");

        System.out.print("J开头的语言有：");
        filter(languages,(str) -> str.startsWith("J"));

        System.out.print("a结束的语言有：");
        filter(languages,(str) -> str.endsWith("a"));

        System.out.print("所有语言：");
        filter(languages,(str) -> true);

        System.out.print("名字长度大于4的语言：");
        filter(languages,(str) -> str.length() > 4);


        // stream
        List<Integer> ages = list.stream().map(s -> s.getAge()).collect(Collectors.toList());
        ages.forEach(System.out::println);
        String names = list.stream().map(s -> s.getName()).collect(Collectors.joining(","));
        System.out.println(names);
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Student::getAge).summaryStatistics();
        System.out.println("max:" + intSummaryStatistics.getMax());
        System.out.println("min" + intSummaryStatistics.getMin());
        System.out.println("sum" + intSummaryStatistics.getSum());
        System.out.println("avg" + intSummaryStatistics.getAverage());
        System.out.println("count" + intSummaryStatistics.getCount());
    }

    public static void filter(List<String> names ,Predicate<String> predicate){
        for (String name : names){
            if (predicate.test(name)){
                System.out.println(name + " ");
            }
        }
    }
}
