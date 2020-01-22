# MVC spring boot

In this article, we will provide a simple example of how to expose a rest api using spring boot.


## Overview

We will create a simple user rest api using the spring boot framework. You can find the configuration of endpoints in the `RestApiController.java` class.

This is what our REST API does:

* GET request to /api/user/ returns a list of users
* GET request to /api/user/1 returns the user with ID 1
* POST request to /api/user/ with a user object as JSON creates a new user
* PUT request to /api/user/3 with a user object as JSON updates the user with ID 3
* DELETE request to /api/user/4 deletes the user with ID 4
* DELETE request to /api/user/ deletes all the users

You can also find a Hello world example from spring tutorials here :

- https://spring.io/guides/gs/rest-service/

And a test a rest controller example from here :

- https://spring.io/guides/gs/testing-web/

We will not use a database in this example. We will use dummy data from a List java object.

### Running the application

It's a spring boot app, you have to run the main method in the `SpringBootRestApiApp.java` class. Or you can use the spring boot maven plugin :

```shell script
$ mvn spring-boot:run
```

After running the application, You can use this list of commands to check if everything run as expected.

* List all users :

```shell script
$ curl localhost:8080/api/user
```

```json
[{"id":1,"login":"user 1","password":"password 1"},{"id":2,"login":"user 2","password":"password 2"},{"id":3,"login":"user 3","password":"password 3"},{"id":4,"login":"user 4","password":"password 4"},{"id":5,"login":"user 5","password":"password 5"}]
```

* Retrieve user by id :

```shell script
$ curl localhost:8080/api/user/1
```

```json
{"id":1,"login":"user 1","password":"password 1"}
```

And if you are not a super fan of the curl command line you can use the postman collection in the resources directory (`resources/postman`).

![rest-api-boot](https://user-images.githubusercontent.com/16627692/72885451-3a938300-3d08-11ea-99cb-bb587a8e32e8.png)

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log
Results :

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.888 s
[INFO] Finished at: 2020-01-22T17:39:55+01:00
[INFO] ------------------------------------------------------------------------
```