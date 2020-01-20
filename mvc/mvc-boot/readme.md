# MVC spring boot

In this article, we will provide a simple example of how to serve web pages using spring boot.


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

```shell script
$ curl localhost:8090/hello-spring-mvc/notFound
```

```json
{"timestamp":1579528527995,"status":404,"error":"Not Found","message":"No message available","path":"/hello-spring-mvc/notFound"}
```

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```
Or using you IDE. Here is my intellij report :

![junit-sql](https://user-images.githubusercontent.com/16627692/72684705-3e928b80-3ae3-11ea-9332-4899a41bf270.png)
