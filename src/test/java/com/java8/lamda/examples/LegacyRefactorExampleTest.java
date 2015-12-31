package com.java8.lamda.examples;


import com.java8.lamda.examples.domain.Album;
import com.java8.lamda.examples.domain.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by prasniths on 31/12/15.
 */
public class LegacyRefactorExampleTest {

    LegacyRefactorExample legacyRefactorExample;

    @Before
    public void setUp() throws Exception {

        legacyRefactorExample = new LegacyRefactorExample();

    }

    @Test
    public void findTracksLeghtOver60Seconds() throws Exception {
        List<String> tracksWithLeght = legacyRefactorExample.getTracksWithLeghtLegacy(getAlbums(), 60);
        checkResult(tracksWithLeght);
    }

    private void checkResult(List<String> tracksWithLeght) {
        assertNotNull(tracksWithLeght);
        assertThat(tracksWithLeght.size(), is(4));
    }

    @Test
    public void findTracksLengthOver60SecodsWithLamda() throws Exception {

        List<String> tracksWithLeght = legacyRefactorExample.getTracksWithLeghtLamda(getAlbums(), 60);
        checkResult(tracksWithLeght);
    }

    @Test
    public void findTracksLengthOver60SecodsWithLamdaRefactor1() throws Exception {

        List<String> tracksWithLeght = legacyRefactorExample.getTracksWithLeghtLamdaWithRefactor1(getAlbums(), 60);
        checkResult(tracksWithLeght);
    }

    @Test
    public void findTracksLenghtOver60SecondsWithLamdaRefactor2() throws Exception {
        List<String> tracksWithLeght = legacyRefactorExample.getTracksWithLeghtLamdaWithRefactor2(getAlbums(), 60);
        checkResult(tracksWithLeght);

    }

    private List<Album> getAlbums() {
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album(getTracks(new Track(50, "Track1"), new Track(70, "Track2"), new Track(65, "Track3")), "TestAlbum"));
        albums.add(new Album(getTracks(new Track(85, "Track1"), new Track(20, "Track12"), new Track(165, "Track31")), "TestAlbum2"));

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