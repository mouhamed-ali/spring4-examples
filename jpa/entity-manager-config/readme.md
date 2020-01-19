# Entity Manager configuration

In this article, we will provide a simple example to show you how to configure the persistence layer of your app.


## Overview

In this example, we will configure an in memory database. We will configure the entity manager factory of our application and customize
the hibernate properties to show the sql queries for example.

In the dao package you will find an example that shows how to inject the entity manager and how to use its methods.


### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.545 s
[INFO] Finished at: 2020-01-18T18:14:56+01:00
[INFO] ------------------------------------------------------------------------

```