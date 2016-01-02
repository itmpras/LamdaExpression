package com.java8.lamda.examples;

import com.java8.lamda.examples.domain.Artist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by prasniths on 01/01/16.
 */
public class Chapter5Test {

    Chapter5 chapter5;

    @Before
    public void setUp() throws Exception {
        chapter5 = new Chapter5();

    }

    @Test
    public void toTestToCollectionMethod() throws Exception {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        TreeSet<Integer> collect = integerStream.collect(toCollection(TreeSet::new));
        assertThat(collect.size(), is(5));
    }

    @Test
    public void toTestStreamPartiions() throws Exception {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> collect = integerStream.collect(partitioningBy(integer -> (integer % 2 == 0)));
        assertNotNull(collect);
        List<Integer> evenIntgers = collect.get(true);
        assertThat(evenIntgers.size(), is(2));
        List<Integer> oddIntegers = collect.get(false);
        assertThat(oddIntegers.size(), is(3));
    }

    @Test
    public void toTestStreamGroupBy() throws Exception {
        List<Artist> artists = getArtists();
        Map<String, List<Artist>> collect = artists.stream().collect(groupingBy(Artist::getLocation));
        assertNotNull(collect);
        List<Artist> artistList = collect.get("London");
        assertThat(artistList.size(), is(2));
    }

    @Test
    public void toTestJoinning() throws Exception {
        List<Artist> artists = getArtists();
        String joinnedString = artists.stream()
                .map(Artist::getName).collect(joining(",", "[", "]"));
        assertThat(joinnedString, is("[John,Pras,Nakul,Nithu]"));
    }

    @Test
    public void toGetArtisitWithLongerName() throws Exception {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

        String name = chapter5.getArtistWithLongerName(names);
        assertThat(name, is("Stuart Sutcliffe"));

    }

    @Test
    public void toMapStringFrequencyCount() throws Exception {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> nameFrequencyCount = chapter5.getStringFrequencyCount(names);
        assertThat(nameFrequencyCount.get("John"), is(3L));
        assertThat(nameFrequencyCount.get("Paul"), is(2L));
        assertThat(nameFrequencyCount.get("George"), is(1L));
    }

    @Test
    public void toTestStringCollector() throws Exception {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
        String collect = names.collect(new StringCollector());
        assertThat(collect,is("[John,Paul,George,John,Paul,John]"));
    }

    @Test
    public void toTestGroupByCollector() throws Exception {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Integer> nameFrequencyCount = chapter5.getStringFrequencyCountByCollector(names);
        assertThat(nameFrequencyCount.get("John"), is(3));
        assertThat(nameFrequencyCount.get("Paul"), is(2));
        assertThat(nameFrequencyCount.get("George"), is(1));

    }

    public List<Artist> getArtists() {

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("John", "London"));
        artists.add(new Artist("Pras", "Chennai"));
        artists.add(new Artist("Nakul", "London"));
        artists.add(new Artist("Nithu", "Trichy"));

        return artists;
    }

}
