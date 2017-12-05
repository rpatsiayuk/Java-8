package com.oracle.collections;

import org.junit.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Collections {

    public void checkSortedAndUnsortedCollections(){
        List<Integer> numbers = asList(5, 2, 3, 4);

        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x + 1)
                .collect(toList());
        stillOrdered.forEach(System.out::print);
        Assert.assertEquals(asList(6, 3, 4, 5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(numbers);
        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(toList());
        stillUnordered.forEach(System.out::print);
        Assert.assertEquals(asList(6, 3, 4, 5), stillUnordered);
    }
}
