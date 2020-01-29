# Transaction Manager configuration

In this article, we will provide some examples to show you how to use database transactions.


## Overview

In this example, we will configure an in memory database (H2) and we will use jdbc template to manipulate the db.

We will discover some interesting features about the spring framework transactions such as how to create one, commit it, rollback it ...

In this example you will discover how to :

- default behavior of the @Transactional annotation
- stop and create a new transaction
- rollback a transaction for a specific error
- read uncommited rows
- order you junit tests
- use the @Transactional with junit to rollback data after running a test
- use @Commit to store the used data of your junit tests

PN : for the last two features, you can find them in the extra package in the test sources directory.

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log

Results :

Tests run: 15, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ transaction-manager-example ---
[INFO] Building jar: /home/salto/tutorials/java/spring4-examples/jpa/transaction-manager-example/target/transaction-manager-example-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.946 s
[INFO] Finished at: 2020-01-29T15:47:05+01:00
[INFO] ------------------------------------------------------------------------

```

My intellij report :

![Selection_010](https://user-images.githubusercontent.com/16627692/73366580-79987a00-42ae-11ea-81d0-e32404a743bc.png)
