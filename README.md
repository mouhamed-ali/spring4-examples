# Spring 4 examples

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

![Selection_190](https://user-images.githubusercontent.com/16627692/72629898-7ec20480-3951-11ea-8cd5-e1274dd00934.png)

`Please Note` : If you want to upgrade the version of one of the dependencies, make sure to check this link :

- https://docs.spring.io/platform/docs/Brussels-SR4/reference/html/appendix-dependency-versions.html

It shows the versions compatibility. It's gonna be use easy to migrate versions using it. Otherwise, you can use the spring bom project to manage the dependencies versions. 

## Running the tests

We are using a travis job to run tests before merging branches. Each tme we create a merge request, travis will download our code on a docker image and run the tests after.

You can check the travis and the docker files to know more.

For unit tests, you gonna find them in each module + some explanations in the source code also.

## Built With

* Java - openjdk version "1.8.0_232"
* [Maven](https://maven.apache.org/) - Dependency Management (version 3.6.0)
* [Intellij](https://www.jetbrains.com/) - IDE (version 11.0.5)
* [Travis](http://travis-ci.org/)
* [Docker](https://www.docker.com/)


## Authors

* **Amdouni Mohamed Ali** [[github](https://github.com/amdouni-mohamed-ali)]

![Spring_framework-1](https://user-images.githubusercontent.com/16627692/72637378-7671c580-3961-11ea-8d00-3f5624480783.png)
