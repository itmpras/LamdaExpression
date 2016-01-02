package com.java8.lamda.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;


public class GroupByCollector implements java.util.stream.Collector<String, Map<String, Integer>, Map<String, Integer>> {

    public static final HashSet<Characteristics> CHARACTERISTICSES = new HashSet<>();

    static {
        CHARACTERISTICSES.add(Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Supplier<Map<String, Integer>> supplier() {
        // return () -> new HashMap<String, Integer>();
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Integer>, String> accumulator() {

        return (map, element) -> {

            if (map.containsKey(element)) {
                Integer integer = map.get(element);
                map.put(element, integer + 1);
            } else {
                map.put(element, 1);
            }
        };
    }

    @Override
    public BinaryOperator<Map<String, Integer>> combiner() {
        return ((stringIntegerMap, stringIntegerMap2) -> {
            stringIntegerMap.putAll(stringIntegerMap2);
            return stringIntegerMap;
        }
        );
    }

    @Override
    public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return CHARACTERISTICSES;
    }
}
