# Spring 4 examples

[![Build Status](https://travis-ci.org/amdouni-mohamed-ali/spring4-examples.svg?branch=master)](https://travis-ci.org/amdouni-mohamed-ali/spring4-examples)
[![codecov](https://codecov.io/gh/amdouni-mohamed-ali/spring4-examples/branch/master/graph/badge.svg)](https://codecov.io/gh/amdouni-mohamed-ali/spring4-examples)

This repository contains simple examples for the different Spring framework modules to showcase the API and how to use it.

We have separate folders for each module :

```
spring4-examples
│
└─── caching
└─── core
└─── jdbc
└─── jpa
└─── junit
└─── mvc
└─── rest
└─── security
└─── soap
```

### Prerequisites

To create your development environment, you will need to :

- install java 8 (or above)
- install maven
- install git to clone the project
- you favorite IDE (i'm using intellij) 
- install docker on your machine

### Installing

To clone the project, run this command :

```
    $ git clone https://github.com/amdouni-mohamed-ali/spring4-examples.git
    $ cd spring4-examples
```

And run this to make that the project compiles :

```
    $ mvn clean package
```

If everything turns out alright, you should end up with this result :

```maven
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ log4j2-simple-example ---
[INFO] Building jar: /home/salto/tutorials/java/spring4-examples/log/log4j2-simple-example/target/log4j2-simple-example-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for spring4-examples 1.0-SNAPSHOT:
[INFO] 
[INFO] spring4-examples ................................... SUCCESS [  0.408 s]
[INFO] core ............................................... SUCCESS [  0.004 s]
[INFO] HelloWorldJavaXmlConfig ............................ SUCCESS [  4.767 s]
[INFO] properties-injection ............................... SUCCESS [  0.680 s]
[INFO] annotations ........................................ SUCCESS [  0.360 s]
[INFO] profiles ........................................... SUCCESS [  3.716 s]
[INFO] properties-boot .................................... SUCCESS [  0.402 s]
[INFO] junit .............................................. SUCCESS [  0.003 s]
[INFO] junit-java-config .................................. SUCCESS [  1.603 s]
[INFO] junit-xml-config ................................... SUCCESS [  1.576 s]
[INFO] custom-test-config ................................. SUCCESS [  1.683 s]
[INFO] test-sql-scripts ................................... SUCCESS [  2.559 s]
[INFO] jpa ................................................ SUCCESS [  0.008 s]
[INFO] entity-manager-config .............................. SUCCESS [  6.228 s]
[INFO] transaction-manager-example ........................ SUCCESS [  4.192 s]
[INFO] spring-data-jpa .................................... SUCCESS [  4.807 s]
[INFO] rest ............................................... SUCCESS [  0.003 s]
[INFO] rest-template ...................................... SUCCESS [  2.193 s]
[INFO] rest-war ........................................... SUCCESS [  0.003 s]
[INFO] rest-war-example ................................... SUCCESS [  6.434 s]
[INFO] rest-war-xml-config ................................ SUCCESS [  0.473 s]
[INFO] rest-war-example-2 ................................. SUCCESS [  1.555 s]
[INFO] rest-boot .......................................... SUCCESS [ 10.234 s]
[INFO] mvc ................................................ SUCCESS [  0.004 s]
[INFO] mvc-boot ........................................... SUCCESS [  9.798 s]
[INFO] mvc-spring ......................................... SUCCESS [  0.003 s]
[INFO] mvc-spring-1 ....................................... SUCCESS [  6.889 s]
[INFO] mvc-spring-2 ....................................... SUCCESS [  3.495 s]
[INFO] security ........................................... SUCCESS [  0.001 s]
[INFO] http-basic ......................................... SUCCESS [  0.752 s]
[INFO] custom-login-page .................................. SUCCESS [  0.726 s]
[INFO] jdbc-authentication ................................ SUCCESS [  7.754 s]
[INFO] jdbc-authentication-2 .............................. SUCCESS [  4.830 s]
[INFO] custom-filter-chain ................................ SUCCESS [  0.514 s]
[INFO] jdbc ............................................... SUCCESS [  0.002 s]
[INFO] jdbc-template-example-1 ............................ SUCCESS [  1.936 s]
[INFO] caching ............................................ SUCCESS [  0.002 s]
[INFO] example-1-boot-app ................................. SUCCESS [  3.035 s]
[INFO] soap ............................................... SUCCESS [  0.002 s]
[INFO] producer ........................................... SUCCESS [  0.002 s]
[INFO] wsdl-approach ...................................... SUCCESS [  1.334 s]
[INFO] consumer ........................................... SUCCESS [  0.002 s]
[INFO] log ................................................ SUCCESS [  0.001 s]
[INFO] log4j2-simple-example .............................. SUCCESS [  0.319 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:37 min
[INFO] Finished at: 2020-02-17T18:30:47+01:00
[INFO] ------------------------------------------------------------------------
```

`Please Note` : If you want to upgrade the version of one of the dependencies, make sure to check this link :

- https://docs.spring.io/platform/docs/Brussels-SR4/reference/html/appendix-dependency-versions.html

It shows the versions compatibility. It's gonna be use easy to migrate versions using it. Otherwise, you can use the spring bom project to manage the dependencies versions. 

In some modules we are using docker to deploy the app so you have to install it. One of the examples is this :

- https://github.com/amdouni-mohamed-ali/spring4-examples/tree/master/mvc/mvc-spring/mvc-spring-1

as the packaging of the app is war, we are using a tomcat:7 docker image to deploy it.

## Running the tests

We are using a travis job to run tests before merging branches. Each tme we create a merge request, travis will download our code and run the tests after.

You can check the travis file to know more or just check this link :

- https://docs.travis-ci.com/user/languages/java/#examples

For unit tests, you gonna find them in each module + some explanations in the source code also.

## Built With

* [Java](https://openjdk.java.net/) - openjdk version "1.8.0_232"
* [Maven](https://maven.apache.org/) - Dependency Management (version 3.6.0)
* [Intellij](https://www.jetbrains.com/) - IDE (version 11.0.5)
* [Travis](http://travis-ci.org/) - CI/CD
* [CodeCov](https://codecov.io/) - Test coverage
* [Docker](https://www.docker.com/) - To create, deploy, and run applications using containers

## Appendices

The list of Spring Boot properties :

- https://docs.spring.io/autorepo/docs/spring-boot/current/reference/htmlsingle/#common-application-properties

## Authors

* **Amdouni Mohamed Ali** [[github](https://github.com/amdouni-mohamed-ali)]

![Spring_framework-1](https://user-images.githubusercontent.com/16627692/72637378-7671c580-3961-11ea-8d00-3f5624480783.png)
