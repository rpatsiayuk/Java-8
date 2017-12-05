package com.oracle.collections;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamPipeMethods {

    public static void main(String[] args) {
        Collection<String> collection = asList("a1","a1", "a2", "a3");
        long count = getElementCount(collection);
        System.out.println(count);

        System.out.println(skipNElements(collection));

        List<String> list = distinctElements(collection);
        list.stream().forEach(System.out:: println);
    }

    //Отфильтровывает записи, возвращает только записи, соответствующие условию
    private static long getElementCount(Collection collection){
       return collection.stream().filter("a1"::equals).count();
    }

    //Позволяет пропустить N первых элементов
    private static Object skipNElements(Collection collection){
        return collection.stream().skip(collection.size() - 1).findFirst().orElse("1");
    }

    //Возвращает стрим без дубликатов (для метода equals)
    private static List distinctElements(Collection collection){
        return (List) collection.stream().distinct().collect(Collectors.toList());
    }



}
