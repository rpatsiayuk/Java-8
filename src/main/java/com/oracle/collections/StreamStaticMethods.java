package com.oracle.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StreamStaticMethods {

    public static void main(String[] args) {
        Collection<String> collection = asList("a1", "a2", "a3");

        //1. Классический: Создание стрима из коллекции
        Stream<String> streamFromCollection = collection.stream();
        streamFromCollection.forEach(System.out::println);

        // Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("1", "2", "3");
        //streamFromValues.forEach(System.out::println);
        System.out.println("streamFromValues = " + streamFromValues.collect(toList()));

        // Создание стрима из массива
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        streamFromArrays.forEach(System.out::println);

        //Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("src\\main\\resources\\com.oracle.files\\stream.txt"));
            List<String> collect = streamFromFiles.collect(toList());
            collect.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Создание стрима из строки
        IntStream streamFromString = "123".chars();
        streamFromString.forEach(System.out::println);

        //С помощью Stream.builder
        Stream.builder().add("a1").add("a2").add("a3").build().forEach(System.out::println);

        /*Stream<Object> builder = Stream.builder().add("a1").add("a2").add("a3").build();
        builder.forEach(System.out::println);*/

        //Создание параллельного стрима
        Stream<String> stream = collection.parallelStream();
        stream.forEach(System.out::println);

        //Создание бесконечных стрима с помощью Stream.iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1).limit(5);
        streamFromIterate.forEach(System.out::println);

        //Создание бесконечных стрима с помощью Stream.generate
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1").limit(3);
        streamFromGenerate.forEach(System.out::println);


        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());

        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());

        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        assertEquals(asList(1, 2, 3, 4), together);

    }
}
