package com.java8.lamda.examples;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * Created by prasniths on 01/01/16.
 */
public class Chapter5 {
    public String getArtistWithLongerName(Stream<String> names) {
        Optional<String> collect = names.collect(Collectors.maxBy(Comparator.comparing(String::length)));
        return collect.get();
    }

    public Map<String, Long> getStringFrequencyCount(Stream<String> names) {
        Map<String, Long> collect = names.collect(Collectors.groupingBy(name -> name, counting()));
        return collect;
    }

    public Map<String, Integer> getStringFrequencyCountByCollector(Stream<String> names) {
        return names.collect(new GroupByCollector());
    }
}
