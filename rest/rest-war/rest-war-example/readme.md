# Rest Spring first example

In this project, we will develop a simple crud web app using spring rest.

## Overview

This is a simple example of how you can create a crud application using :

- spring rest to serve json objects
- spring test to make mvc tests
- maven plugin to generate a war
- docker to run the generated war

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
$ docker logs rest-app-1
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the application, you can test the rest endpoints using these commands :

* List all customers :

```shell script
$ curl http://localhost:8080/rest-war-example/customers
```

```json
[{"id":101,"firstName":"John","lastName":"Doe","email":"djohn@gmail.com","mobile":"121-232-3435","dateOfBirth":1579789950273},{"id":201,"firstName":"Russ","lastName":"Smith","email":"sruss@gmail.com","mobile":"343-545-2345","dateOfBirth":1579789950273},{"id":301,"firstName":"Kate","lastName":"Williams","email":"kwilliams@gmail.com","mobile":"876-237-2987","dateOfBirth":1579789950273}]
```

* Retrieve a customer by id :

```shell script
$ curl http://localhost:8080/rest-war-example/customers/101
```

```json
{"id":101,"firstName":"John","lastName":"Doe","email":"djohn@gmail.com","mobile":"121-232-3435","dateOfBirth":1579789950273}
```

More examples of how to use curl here :

- https://gist.github.com/subfuzion/08c5d85437d5d4f00e58

And if you are not a super fan of the curl command line you can use the postman collection in the resources directory (`resources/postman`).

![spring-rest-war-1-postman](https://user-images.githubusercontent.com/16627692/72993910-76a51180-3df6-11ea-8d34-78079acf1a29.png)


### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log
Results :

Tests run: 9, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-war-plugin:2.4:war (default-war) @ rest-war-example ---
[INFO] Packaging webapp
[INFO] Assembling webapp [rest-war-example] in [/home/salto/tutorials/java/spring4-examples/rest/rest-war/rest-war-example/target/rest-war-example]
[INFO] Processing war project
[INFO] Webapp assembled in [87 msecs]
[INFO] Building war: /home/salto/tutorials/java/spring4-examples/rest/rest-war/rest-war-example/target/rest-war-example.war
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.973 s
[INFO] Finished at: 2020-01-23T15:26:22+01:00
[INFO] ------------------------------------------------------------------------

```

My intellij report :

![spring-rest-war-1-report](https://user-images.githubusercontent.com/16627692/72992530-2b89ff00-3df4-11ea-91e9-39afd86700bc.png)
