# Rest Spring Second example

In this project, we will develop a simple crud web app using spring rest.

## Overview

This is the same as the last example (a rest crud application), but in this project we will explain how :

- to serve json and xml depends on the request header
- how to handle errors in the controller and produce response with details of the error
- how to set the response HTTP status code for a specific error
- how to use annotations like @ControllerAdvice and @ExceptionHandler

you will find deep explanation in this article :

- https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

and an @ControllerAdvice example here :

- https://www.baeldung.com/spring-exceptions-json

To deploy the app you can use the generated war (you can find it in the target directory) to install it on your server.

Otherwise, the simplest way is to use the given docker image to deploy it (i'm using tomcat 7 to deploy the app).

### Running the application

Before running the app you have to generate the war file using this command :

```shell script
$ mvn clean package
```

To run the app, run this docker command (from the current directory):

```shell script
$ docker-compose up --build
```

To get logs, you can use this :

```shell script
$ docker logs rest-app-2
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

### Running the tests

There is no junit tests provided with this project but you have a postman collection in the resources directory. Use it if you want.

![spring-rest-war-2-postman](https://user-images.githubusercontent.com/16627692/73072689-e9c18d00-3eb5-11ea-8f76-2da945df353c.png)
