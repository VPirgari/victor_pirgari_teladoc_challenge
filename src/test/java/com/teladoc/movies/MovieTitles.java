package com.teladoc.movies;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovieTitles {


    public static String[] getMoviesTitles(String substr) {

        //Stored the baseURI so the code will be cleaner
        baseURI = "https://jsonmock.hackerrank.com/api";

        //Initialize response to store the response from request
        Response response = given()
                //Asking for a JSON response
                .accept(ContentType.JSON)
                //Providing query parameters to request
                .and().queryParam("Title", substr)
                .when()
                //Getting the response from the end point
                .get("/movies/search")
                //Other way to get the request providing query parameters to the endpoint
/**                .get(baseURI + "/?Title=" + substr) */
                //Validating the response status code is 200 , which means successful request
                .then().statusCode(200)
                //Validating that the response Header is "application/json" and we got JSON object response
                .and().contentType("application/json")
                //Extracting to a response
                .extract().response();

        //As I don't have JSON Schema to validate it, went hard way to test the response
        //Validating by checking that each line is not null
        assertThat("There is no \"page\" in JSON response",
                response.path("page"), is(notNullValue()));
        assertThat("There is no \"per_page\" in JSON response",
                response.path("per_page"), is(notNullValue()));
        assertThat("There is no \"total\" in JSON response",
                response.path("total"), is(notNullValue()));
        assertThat("There is no \"total_pages\" in JSON response",
                response.path("total_pages"), is(notNullValue()));
        assertThat("There is no \"data\" in JSON response",
                response.path("data"), is(notNullValue()));

        //Storing total pages in an int variable from response so I can use it in the script
        int totalPages = response.path("total_pages");
        //Storing total movies from response in an int for future use
        int totalMovies = response.path("total");

        //Validating that there are no 0 movies in response
        assertThat("There is no movies available with this title",
                totalMovies, is(greaterThan(0)));
        //Validating that there are pages available
        assertThat("There is no pages available",
                totalPages, is(greaterThan(0)));

        //Creating an array of String providing length of array which I got from response
        String[] titles = new String[totalMovies];

        //Initialize  an int for future use for index of array titles
        int index = 0;

        //first for loop to get the results based on each page where 'i' is the number of page
        for (int i = 1; i <= totalPages; i++) {

            //Storing each page response in a JsonPath object and validating the response
            //Probably could go with an if statement to check if it's just 1 page not to get the request one more time
            JsonPath jsonPath = given()
                    .accept(ContentType.JSON)
                    .and().queryParam("Title", substr)
                    .and().queryParam("page", i)
                    .when()
                    .get("/movies/search")
                    .then().statusCode(200)
                    .and().contentType("application/json")
                    .extract().jsonPath();

            //Validating that with each page there is space left (null) in array
            //In case of failure means total provided by response is not right and there are more movies
            assertThat("There are more movies provided in pages than in \"total\"." +
                            "Assert failure in page : " + i,
                    ((titles.length - 1) - index), is(greaterThanOrEqualTo(0)));

            //Nested loop. 'j' is the index of each JSON object in data array
            for (int j = 0; j < jsonPath.getList("data.Title").size(); j++) {
                //Validating that movie JSON object has the Title
                //Could come with more validations for "Poster", "Type", "Year","imbdID"
                //Validating by checking if it's not null
                assertThat("There is no \"Title\" for this movie in JSON object." +
                                "Assert Failure at page : " + i,
                        jsonPath.getString("data[" + j + "].Title"), is(notNullValue()));

                //Storing in titles array the Title of movie
                //"index" is the index of the array, 'j' is the index of each object in data array
                titles[index] = jsonPath.getString("data[" + j + "].Title");
                //Incrementing the index of titles array as it has stored already in previous
                index++;
            }
        }
        //Validating that there are total movies as provided in response
        //Same time validating that the script got all  movie titles
        assertThat("There are less movies in pages than provided in total in response",
                index, is(equalTo(totalMovies)));
        //Sorting the array of titles
        Arrays.sort(titles);

        //Printing as an array
        System.out.println(Arrays.toString(titles));
        System.out.println();

        //Printing as expected output
        for (int i = 0; i < titles.length; i++) {
            System.out.println(titles[i]);
        }

        System.out.println();


        return titles;

    }
}
