# victor_pirgari_teladoc_challenge

Script written in Java.

Pre-requisites needed:
To be installed:
JDK- 8 link : https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html
Maven  link : https://maven.apache.org/install.html

For windows:
Having installed JDK and Maven.
Code can be run from powershell or commnand promt:
-Make sure you are on framework directory.
-Type : mvn test -Dtest="com.teladoc.movies.Runner" -Dsubstr="substrToBeTested" (change the substrToBeTested with desired substring for search)
-By default substr is "spiderman" , if you want to use devault value : Type : mvn test -Dtest="com.teladoc.movies.Runner"

Using IDE (IntelliJ or Eclipse):
Command line type : mvn test -Dtest="com.teladoc.movies.Runner" -Dsubstr="substrToBeTested" (change the substring with desired substring for search)
-By default substr is "spiderman" , if you want to use devault value : Type : mvn test -Dtest="com.teladoc.movies.Runner".
-Or you can run Runner.java class and change String defaultValue to desired substr.

Will come up with more details later today.
