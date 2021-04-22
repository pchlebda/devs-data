# Compressed password protected csv file parse application.
* The purpose of that application is to parse zipped password protected csv file and send matching results to `http://54.70.230.245:80/`.

## Requirements
* Java 11
* Maven 3.6.0

## How to build application
* Run command `mvn clean package -U` . The application `file-reader.jar` can be found in `target`

## How to run the app
* Once the application is built it can be run `java -jar {PATH_TO_JAR} {ZIPPED_GFILE} {PASSWORD}`  e.g `java -jar target/file-reader.jar file.zip pass123`

## How to run tests
* Run `mvn test`