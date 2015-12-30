package com.java8.lamda.examples.domain;

import java.util.Objects;

/**
 * Created by gopalp on 30/12/2015.
 */
public class Artist {
   private final String name;
   private final String location;

   public Artist(String name, String location) {
      this.name = name;
      this.location = location;
   }

   @Override
   public String toString() {
      return "Artist{" +
         "name='" + name + '\'' +
         ", location='" + location + '\'' +
         '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Artist artist = (Artist) o;
      return Objects.equals(name, artist.name) &&
         Objects.equals(location, artist.location);
   }
   @Override
   public int hashCode() {
      return Objects.hash(name, location);
   }
   public boolean isFrom(String artistLocation) {
      return location.equals(artistLocation);
   }
}



