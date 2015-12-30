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
      Stream<Artist> london = list.stream().filter(artist -> (artist.isFrom("London")));
      long count = london.count();
      london.close();
      london = list.stream().filter(artist -> (artist.isFrom("London")));
      london.forEach(artist -> {
         System.out.println(artist);
      });
      london.close();

      london = list.stream().filter(artist -> (artist.isFrom("London")));
      List<Artist> collect = london.collect(Collectors.toList());

      System.out.println("Artist Count :" + count);
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
