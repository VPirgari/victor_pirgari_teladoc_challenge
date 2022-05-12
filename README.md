# victor_pirgari_teladoc_challenge

##API homework assignment

>Function Description
Given a string substr, getMovieTitles must perform the following tasks:
1. Query
   https://jsonmock.hackerrank.com/api/movies/search/?Title=subst
   r(replace substr).
2. Initialize the titles array to store total string elements. Store the Title of each
   movie meeting the search criteria in the titles array.
3. Sort titles in ascending order and return it as your answer.


###Script is written in Java.

###Pre-requisites needed:
To be installed:
>JDK- 8  download [Link](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)

>Maven installation guide [link](https://maven.apache.org/install.html)

###For windows:
Having installed JDK and Maven.

Code can be run from powershell or commnand promt:

>Make sure you are on framework directory.

>Type : mvn test -Dtest="com.teladoc.movies.Runner" -Dsubstr="substrToBeTested" (change the substrToBeTested with desired substring for search)

> -By default substr is "spiderman" , if you want to use devault value : Type : mvn test -Dtest="com.teladoc.movies.Runner"

###Using IDE (IntelliJ or Eclipse):
>Run TestRunner.java class and change/add String in @CsvSource  to desired substr.

>Command line type : mvn test -Dtest="com.teladoc.movies.Runner" -Dsubstr="substrToBeTested" (change the substring with desired substring for search)

>By default substr is "spiderman" , if you want to use default value : Type : mvn test -Dtest="com.teladoc.movies.Runner".
can run Runner.java class and change String defaultValue to desired substr.

Will come up with more details later today.
