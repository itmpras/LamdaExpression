package com.java8.lamda.examples.domain;

/**
 * Created by prasniths on 31/12/15.
 */
public class Track {
    private final String trackName;
    private final int length;

    public Track(int length, String trackName) {
        this.length = length;
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (length != track.length) return false;
        return !(trackName != null ? !trackName.equals(track.trackName) : track.trackName != null);

    }

    @Override
    public int hashCode() {
        int result = trackName != null ? trackName.hashCode() : 0;
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackName='" + trackName + '\'' +
                ", length=" + length +
                '}';
    }
}
