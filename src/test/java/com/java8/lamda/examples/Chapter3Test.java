package com.java8.lamda.examples;

import com.java8.lamda.examples.domain.Album;
import com.java8.lamda.examples.domain.Artist;
import com.java8.lamda.examples.domain.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class Chapter3Test {

    Chapter3 chapter3;

    @Before
    public void setUp() throws Exception {
        chapter3 = new Chapter3();

    }

    @Test
    public void verifyCommonStreamOperationWithAddUp() throws Exception {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        int sum = chapter3.sumUp(integerStream);
        assertThat(sum, is(15));
    }

    @Test
    public void verifyCommonStreamOperationWithArtist() throws Exception {
        List<String> names = chapter3.getArtistNameAndLocation(getArtists());
        assertNotNull(names);
        assertThat(names.size(), is(4));
    }

    @Test
    public void verifyCommonStreamOperationWithAlbum() throws Exception {
        List<Album> result = chapter3.getAlbumsWithAtleastTracks(getAlbums(), 3);
        assertNotNull(result);
        assertThat(result.size(), is(2));

    }

    @Test
    public void shouldReturnMemberCountCorrectlyUsingExternalIteration() throws Exception {
        List<Artist> artists = getArtists();
        Artist artist = new Artist("Beatles", "LiverPool", artists);
        artists.add(artist);
        int legacyMemebersCount = chapter3.legacyMemebersCount(artists);
        assertThat(legacyMemebersCount, is(4));
    }

    @Test
    public void shouldReturnMemberCountCorrectly() throws Exception {
        List<Artist> artists = getArtists();
        Artist artist = new Artist("Beatles", "LiverPool", artists);
        artists.add(artist);
        int legacyMemebersCount = chapter3.lamdaMemebersCount(artists);
        assertThat(legacyMemebersCount, is(4));
    }

    @Test
    public void shouldReturnLowerCaseCount() throws Exception {

        String testString = "testString";
        int count = chapter3.getLowerCaseCountFor(testString);
        assertThat(count, is(testString.length() - 1));

    }

    @Test
    public void shouldReturnLargestLowerCaseCount() throws Exception {

        List<String> strings = Arrays.asList("testString", "test", "pras", "gopi");
        int count = chapter3.getLowerCaseCountFor(strings);
        assertThat(count, is("testString".length() - 1));

    }

    @Test
    public void verifyMapImplementation() throws Exception {
        List<Artist> artists = getArtists();
        Function<Artist, String> artistToNameFunction = artist -> artist.getName();
        List<String> collect = artists.stream().map(artistToNameFunction).collect(toList());
        List<String> mapImplementationUsingReduce = chapter3.mapImplementationUsingReduce(artists, artistToNameFunction);
        assertThat(collect.size(), is(4));
        assertThat(mapImplementationUsingReduce.size(), is(4));
    }

    @Test
    public void verifyFilterImplementation() throws Exception {
        List<Artist> artists = getArtists();
        Predicate<Artist> artistStartingNamePredicate = artist -> artist.getName().startsWith("N");
        List<Artist> collect = artists.stream().filter(artistStartingNamePredicate).collect(toList());
        List<Artist> result = chapter3.filterImplementationUsingReduce(artists, artistStartingNamePredicate);
        assertThat(collect.size(), is(2));
        assertThat(result.size(), is(2));
    }

    public List<Artist> getArtists() {

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("John", "London"));
        artists.add(new Artist("Pras", "Chennai"));
        artists.add(new Artist("Nakul", "London"));
        artists.add(new Artist("Nithu", "Trichy"));

        return artists;
    }


    private List<Album> getAlbums() {
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album(getTracks(new Track(50, "Track1"), new Track(70, "Track2")), "TestAlbum"));
        albums.add(new Album(getTracks(new Track(85, "Track1"), new Track(20, "Track12"), new Track(165, "Track31")), "TestAlbum2"));
        albums.add(new Album(getTracks(new Track(50, "Track1"), new Track(70, "Track2"), new Track(70, "Track2"), new Track(70, "Track2")), "TestAlbum3"));

        return albums;
    }

    private List<Track> getTracks(Track... tracks) {

        ArrayList<Track> tracksList = new ArrayList<Track>();
        for (Track track : tracks) {
            tracksList.add(track);
        }

        return tracksList;
    }
}