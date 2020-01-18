# Entity Manager configuration

In this article, we will provide a simple example to show how to setup and use spring data.


## Overview

In this example, we will configure an in memory database (H2). We will add the famous spring data interface that extends the JpaRepository interface.

You can find the repository in the dao package and services in the service package.

We will provide some interesting tests to show how to use @Sql annotation to run an insert sql script for example before running the test and how to purge the database after.

In this example you will discover how to :

- create users table
- retrieve a user by criteria
- CRUD operations on a user
- count the number of users
- use pagination
- use sort in a request

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.651 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.687 s
[INFO] Finished at: 2020-01-18T19:49:12+01:00
[INFO] ------------------------------------------------------------------------

```