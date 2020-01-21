# MVC spring boot

In this article, we will provide a simple example of how to serve web pages using spring boot. We are using thymeleaf as a template engine.


## Overview

We will create a simple hello world web page using the spring boot framework. You can find the configuration in the `SpringBootStandAloneApp.java` class.

As this is maven multi-modules project, i didn't inherit my project from the spring parent pom. I would like to manage my dependencies myself.

This is one of the examples i faced many issues to set it up. Spring boot didn't bring some of the dependencies and you have to import them manually.

The spring boot version is 1.5.6.RELEASE and here is its pom.xml which contains all used versions :

- http://repo.spring.io/milestone/org/springframework/boot/spring-boot-dependencies/1.5.6.RELEASE/spring-boot-dependencies-1.5.6.RELEASE.pom

Check the pom.xml of this file, you'll notice that i added manually the thymeleaf libraries to work with spring. For version check the the link i shared in the main read me file.

To know more about the dependencies of the project and which one get ignored, run this command :

```shell script
$ mvn dependency:tree
```

You can find an another example on the spring site :

- https://spring.io/guides/gs/serving-web-content/

### Running the application

It's a spring boot app, you have to run the main method in the `SpringBootStandAloneApp.java` class. Or you can use the spring boot maven plugin :

```shell script
$ mvn spring-boot:run
```

Check the `application.yaml` file to get the app context and the server port.

After running the application, check these links to see the controllers responses :

- http://localhost:8090/hello-spring-mvc/

![mvc-1-hello](https://user-images.githubusercontent.com/16627692/72731605-4cecb000-3b94-11ea-893b-9ae15a329d01.png)

```shell script
$ curl localhost:8090/hello-spring-mvc/greeting
```

```html
<!DOCTYPE HTML>

<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p>Hello, World!</p>
</body>
</html>
```

```shell script
$ curl localhost:8090/hello-spring-mvc/greeting?name=John
```

```html
<!DOCTYPE HTML>

<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p>Hello, John!</p>
</body>
</html>
```

- http://localhost:8090/hello-spring-mvc/notFound

![mvc-1-error](https://user-images.githubusercontent.com/16627692/72732653-6e4e9b80-3b96-11ea-9586-7314a5c26f44.png)


### Running the tests

We gonna use MockMvc class to mock the controllers responses.

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log
Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.604 s
[INFO] Finished at: 2020-01-20T15:28:40+01:00
[INFO] ------------------------------------------------------------------------
```