package com.java8.lamda.examples.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by prasniths on 31/12/15.
 */
public class Album {
    private final List<Track> tracks;
    private final String albumName;

    public Album(List<Track> tracks, String albumName) {
        this.tracks = tracks;
        this.albumName = albumName;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Stream<Track> getTrackStream() {
        return tracks.stream();
    }

    public String getAlbumName() {
        return albumName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (tracks != null ? !tracks.equals(album.tracks) : album.tracks != null) return false;
        return !(albumName != null ? !albumName.equals(album.albumName) : album.albumName != null);

    }

    @Override
    public int hashCode() {
        int result = tracks != null ? tracks.hashCode() : 0;
        result = 31 * result + (albumName != null ? albumName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "tracks=" + tracks +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}

