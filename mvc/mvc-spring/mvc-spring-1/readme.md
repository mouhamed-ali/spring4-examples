# MVC Spring first example

In this project, we will develop a simple crud web app using spring mvc.

## Project structure

This is a simple example of how you can create a crud application using :

- spring mvc to serve web pages
- spring data jpa to manage the persistence of your app
- spring test to make mvc tests

If you want a more 'easy' example, you can follow this article :

- https://www.boraji.com/spring-4-mvc-hello-world-example

If there is something not so clear, you can have a look at the documentation at any time (but i've already explain many things in comments. check the code) :

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc

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
$ docker logs web-app
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the application, you can get access from this link :

- http://localhost:8080/mvc-spring-1/hello-mvc/user/index

![mvc-1-index](https://user-images.githubusercontent.com/16627692/72800501-cd201d80-3c47-11ea-9e5a-6c450c1afeac.png)

You can now manage users from the provided links (Add user and show users).

### Running the tests

We gonna use MockMvc class to mock the controllers responses. Check the code, you gonna find all needed methods to test you mvc controller. There is also a class test of the persistence layer.

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log
Results :

Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.680 s
[INFO] Finished at: 2020-01-21T15:38:14+01:00
[INFO] ------------------------------------------------------------------------
```

My intellij report :

![mv1-test-report](https://user-images.githubusercontent.com/16627692/72813615-f353b680-3c63-11ea-8325-3f0fce5d6dc9.png)
