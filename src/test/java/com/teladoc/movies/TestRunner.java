package com.teladoc.movies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRunner {

    @ParameterizedTest
    @CsvSource               ("spiderman")
    public void testMethod(String substr){
        MovieTitles.getMoviesTitles(substr);
    }
}
