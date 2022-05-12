package com.teladoc.movies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Runner {

    @DisplayName("Get request to all movies and print in a sorted array")
    @Test
    public void allMovies() {
        String defaultValue = "spiderman";

        //providing system properties substr with default value "spiderman"
        String substr = System.getProperty("substr", defaultValue);

        //Calling the method from movies class and storing in an array of String
        String[] moviesTitles = MovieTitles.getMoviesTitles(substr);

    }
}
