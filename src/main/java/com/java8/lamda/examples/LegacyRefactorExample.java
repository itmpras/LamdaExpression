package com.java8.lamda.examples;

import com.java8.lamda.examples.domain.Album;
import com.java8.lamda.examples.domain.Track;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by prasniths on 31/12/15.
 */
public class LegacyRefactorExample {


    public List<String> getTracksWithLeghtLegacy(List<Album> albums, int lenght) {

        ArrayList<String> trackArrayList = new ArrayList<String>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {

                if (track.getLength() >= lenght) {
                    trackArrayList.add(track.getTrackName());
                }
            }
        }

        return trackArrayList;

    }

    public List<String> getTracksWithLeghtLamda(List<Album> albums, int lenght) {

        ArrayList<String> trackArrayList = new ArrayList<String>();

        albums.stream().forEach(album -> {

            album.getTracks().stream().forEach(
                    track -> {
                        if (track.getLength() >= lenght) {
                            trackArrayList.add(track.getTrackName());
                        }
                    }

            );

        });

        return trackArrayList;
    }


    public List<String> getTracksWithLeghtLamdaWithRefactor1(List<Album> albums, int length) {
        ArrayList<String> trackArrayList = new ArrayList<String>();
        albums.stream().forEach(album -> {

            album.getTracks().stream().filter(track -> track.getLength() > length)
                    .map(track1 -> track1.getTrackName())
                    .forEach(name -> trackArrayList.add(name));
        });

        return trackArrayList;
    }

    public List<String> getTracksWithLeghtLamdaWithRefactor2(List<Album> albums, int length) {

        return albums.stream().flatMap(album -> album.getTrackStream())
                .filter(track -> track.getLength() > length)
                .map(track1 -> track1.getTrackName())
                .collect(toList());
    }
}
