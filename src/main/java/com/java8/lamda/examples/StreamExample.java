package com.java8.lamda.examples;

import com.java8.lamda.examples.domain.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gopalp on 30/12/2015.
 */
public class StreamExample {
    public static void main(String[] args) {

        List<Artist> list = getListOfArtists();
        long count = getCount(list);
        System.out.println("Artist Count :" + count);
        printArtist(list);
        collectStream(list);
        reduce();


    }

    private static void reduce() {
        int reducedValue = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> {
                    System.out.println("acc : " + acc + "element :"+ element );
                    return acc + element;});

        System.out.println("Reduce :" + reducedValue);
    }

    private static void collectStream(List<Artist> list) {
        Stream<Artist> london;

        london = list.stream().filter(artist -> (artist.isFrom("London")));
        List<Artist> collect = london.collect(Collectors.toList());
        System.out.println("Collected Artist count " + collect.size());
    }

    private static void printArtist(List<Artist> list) {
        Stream<Artist> london;
        london = list.stream().filter(artist -> (artist.isFrom("London")));
        london.forEach(artist -> {
            System.out.println(artist);
        });
        london.close();
    }

    private static long getCount(List<Artist> list) {
        Stream<Artist> london = list.stream().filter(artist -> (artist.isFrom("London")));
        long count = london.count();
        london.close();
        return count;
    }

    private static List<Artist> getListOfArtists() {

        ArrayList<Artist> list = new ArrayList<>();
        list.add(new Artist("John", "London"));
        list.add(new Artist("Michal", "Northampton"));
        list.add(new Artist("Michal", "MK"));
        list.add(new Artist("Rodger", "London"));
        return list;
    }
}
