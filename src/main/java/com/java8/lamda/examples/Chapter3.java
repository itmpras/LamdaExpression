package com.java8.lamda.examples;

import com.java8.lamda.examples.domain.Album;
import com.java8.lamda.examples.domain.Artist;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Chapter3 {
    public int sumUp(Stream<Integer> integerStream) {
        return integerStream.reduce(0, (acc, element) -> acc + element);
    }

    public List<String> getArtistNameAndLocation(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getName() + " " + artist.getLocation())
                .collect(toList());
    }

    public List<Album> getAlbumsWithAtleastTracks(List<Album> albums, int minTrackCount) {

        return albums.stream().filter(album -> album.getTracks().size() >= minTrackCount)
                .collect(toList());
    }


    public int legacyMemebersCount(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        return totalMembers;
    }

    public int lamdaMemebersCount(List<Artist> artists) {
        return (int) artists.stream().map(artist -> artist.getMembers())
                .map(artist -> artist.count())
                .reduce(0L, (acc, count) -> acc + count).intValue();
    }


    public int getLowerCaseCountFor(String testString) {
        IntStream chars = testString.chars();
        return (int) chars.filter(value -> value >= 'a' && value <= 'z').count();
    }

    public int getLowerCaseCountFor(List<String> strings) {
        OptionalLong max = strings.stream().map(string -> string.chars())
                .mapToLong(intStream -> intStream.filter(value -> value >= 'a' && value <= 'z')
                        .count()
                ).max();
        return (int) max.getAsLong();
    }

    public List<String> mapImplementationUsingReduce(List<Artist> artists, Function<Artist, String> artistToNameFunction) {
        List<String> names = new ArrayList<>();
        artists.stream().reduce(null, (acc, artist) -> {
            names.add(artistToNameFunction.apply(artist));
            return artist;
        });
        return names;
    }

    public List<Artist> filterImplementationUsingReduce(List<Artist> artists, Predicate<Artist> namePredicate) {
        List<Artist> artistList = new ArrayList<>();
        artists.stream().reduce(null, (acc, artist) -> {
            if (namePredicate.test(artist)) {
                artistList.add(artist);
            }

            return artist;
        });
        return artistList;
    }
}
