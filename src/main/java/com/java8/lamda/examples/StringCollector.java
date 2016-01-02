package com.java8.lamda.examples;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class StringCollector implements Collector<String, StringCombiner, String> {

    public static final HashSet<Characteristics> CHARACTERISTICSES = new HashSet<>();

    static {
        CHARACTERISTICSES.add(Characteristics.UNORDERED);
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(",", "[", "]");
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::result;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return CHARACTERISTICSES;
    }
}