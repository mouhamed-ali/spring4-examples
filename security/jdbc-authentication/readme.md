# Basic authentication using JDBC 

In this project, we will secure a simple mvc crud application using spring.

## Overview

In this example we gonna secure the crud web application developed in a previous example. You can find it here :

- https://github.com/amdouni-mohamed-ali/spring4-examples/tree/master/mvc/mvc-spring/mvc-spring-2

We will secure the app with a basic authentication but this time we will retrieve our app users from a database. The used database is H2 and you can find the scripts of creation of the schema and insertion of data in the resources.

The list of users and roles is as below :

|  User | Password | Roles   |
|---|---|---|
| user | user | USER  |
| admin  | admin | ADMIN  |

We change the log level because i faced an entity manager error use it in you projects

Our security rules are described in `SecurityConfig.java` file. As we have two roles, we gonna let the USER role retrieve data (list of users)
only and we gonna give all others permissions to the ADMIN role. This table will explain more :

| ROLE  |  Get users | create user  | update user data | delete user  |
|---|---|---|---|---|
| USER  | Yes  | No  | No  | No  |
| ADMIN  | Yes  | Yes  |  Yes | Yes  |



### Running the application

Before running the app you have to generate the war file using this command :

```shell script
$ mvn clean package
```

You can delete the file named `logging.properties` from the resources. it is used to change the level log of our server to INFO.

To run the app, run this docker command (from the current directory):

```shell script
$ docker-compose up --build
```

To get logs, you can use this :

```shell script
$ docker logs jdbc-authentication
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the app, you can get access from this link :

- http://localhost:8080/jdbc-authentication/

![login](https://user-images.githubusercontent.com/16627692/73124007-60ce5280-3f96-11ea-9c5c-5c71a36ec278.png)

Use one of the users form the list above.

* User welcome page 

![welcome](https://user-images.githubusercontent.com/16627692/73124008-6166e900-3f96-11ea-9f58-cccfbb4d3cef.png)

* Try to add a new user

![add](https://user-images.githubusercontent.com/16627692/73124005-60ce5280-3f96-11ea-8c24-a22e36fb231b.png)

* You will have this error

![error](https://user-images.githubusercontent.com/16627692/73124006-60ce5280-3f96-11ea-87fd-b4d73dedc61e.png)

### Running the tests

Just execute this command to run unit tests :

```shell script
$ mvn test
```

```log
Results :

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.384 s
[INFO] Finished at: 2020-01-25T19:33:03+01:00
[INFO] ------------------------------------------------------------------------
```

To know more about testing secured services, have a look at this article :

- https://docs.spring.io/spring-security/site/docs/current/reference/html/test.html