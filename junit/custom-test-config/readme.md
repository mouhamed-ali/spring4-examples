# Custom test config

In this article, we will provide two examples to show you how to load beans configurations in a test class.


## Overview

In this example, we will provide two examples :

- in the first one we will load a bean (simple User with first name and last name) from a java configuration class (annotated with @Configuration)
- in the second example we will load the user bean from an xml file

This beans configuration will be valid only for tests. Actually it will override the configuration declared in the app.

Check tests classes to know more.

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.218 s
[INFO] Finished at: 2020-01-19T15:58:59+01:00
[INFO] ------------------------------------------------------------------------


```