# Spring JDBC Template

In this article, we will provide a simple example to show you how to use the spring jdbc template.


## Overview

You can find the app configuration in ApplicationConfig.java. We will use an in memory database (H2). When we start the app, some sql scripts will initialize this last database.

You can find these scripts in the resources directory. In the dao package, we declared the repo classes. These are the used classes to retrieve data from the database. 

You will find there the different methods to get data.


### Running the tests

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
[INFO] Total time:  2.212 s
[INFO] Finished at: 2020-01-18T13:46:39+01:00
[INFO] ------------------------------------------------------------------------
```