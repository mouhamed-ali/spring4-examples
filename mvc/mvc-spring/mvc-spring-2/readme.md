# MVC Spring second example

In this project, we will develop a  crud web app using spring mvc.

## Overview

This is the same example as the last one (spring example 1) except that :

- This time we will use jsp pages and html pages
- We will configure 2 dispatcher servlet the first one will take care of serving jsp pages and the second will serve html pages (using thymeleaf templating)
- we will not make unit tests, if you need to check the last example
- we will not use a persistence layer, we gonna use a simple Java List to store users

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
$ docker logs  web-app-2
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the application, you can get access from this link :

- http://localhost:8080/mvc-spring-2/example/welcome?name=spring

![spring-mvc-2-first-dispatcher](https://user-images.githubusercontent.com/16627692/72877884-2a74a700-3cfa-11ea-8a1b-46caa4282bd3.png)

We used the first dispatcher servlet that serves the jsp pages. To get all endpoints check the `HelloWorldController.java` class in the controller package.

You can access the second dispatcher servlet via this link :

- http://localhost:8080/mvc-spring-2/user/index

![spring-mvc-2-second-dispatcher](https://user-images.githubusercontent.com/16627692/72878109-a2db6800-3cfa-11ea-8964-7dbd56f549ca.png)


This dispatcher will serve html page. You can check these classes to know more about configuration :

- [first dispatcher configuration](https://github.com/amdouni-mohamed-ali/spring4-examples/blob/master/mvc/mvc-spring/mvc-spring-2/src/main/java/org/spring/tutorial/mvc/MvcConfig.java)
- [first second configuration](https://github.com/amdouni-mohamed-ali/spring4-examples/blob/master/mvc/mvc-spring/mvc-spring-2/src/main/java/org/spring/tutorial/mvc/MvcConfigUser.java)
- [dispatchers declaration](https://github.com/amdouni-mohamed-ali/spring4-examples/blob/master/mvc/mvc-spring/mvc-spring-2/src/main/java/org/spring/tutorial/mvc/MyWebInitializer.java)