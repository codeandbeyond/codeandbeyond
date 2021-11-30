package optum.concepts.features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
//        Stream<Integer> streams = Stream.of(new Integer[]{1, 2, 2, 3, 4});
//        //  List<Integer> integerList = streams.collect(Collectors.toList());
//        //System.out.println(integerList);
//
//        Set<Integer> integerSet = streams.collect(Collectors.toSet());
//        System.out.println(integerSet);
//
//        streams = Stream.of(new Integer[]{1, 2, 3, 4});
//        Map<Integer, Integer> map = streams.collect(Collectors.toMap(i -> i, i -> i * 10));
//        System.out.println(map);

//        List<Integer> integersList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            integersList.add(i);
//        }
//        Stream<Integer> integerStream = integersList.stream();
//        Stream<Integer> eventStream = integerStream.filter(i -> i % 2 == 0);
//        eventStream.forEach(num -> System.out.print(num + " "));
//
//        Stream<String> names = Stream.of("aBc", "d", "ef");
//        names.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(names.map(s -> {
//            return s.toUpperCase();
//        }).collect(Collectors.toList()));
        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
        Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());
        flatStream.forEach(System.out::println);
    }
}
