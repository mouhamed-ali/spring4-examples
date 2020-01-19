# Junit java config

In this article, we will provide a simple example of how you can configure your app using the java configuration.


## Overview

This is  a very simple example in which we used the @Bean annotation to declare a bean and @ComponentScan to declare the package(s) that holds our app configuration.

### Running the app

You can run the Main.java class (simple main method). In this class we used the ApplicationContext class to get the loaded spring context then we can retrieve our beans by theirs names.

```log
Jan 19, 2020 4:18:53 PM org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5197848c: startup date [Sun Jan 19 16:18:53 CET 2020]; root of context hierarchy
Customer [identifier=2, firstName=customer2, lastName=customer2]

Process finished with exit code 0
```

As you can see from logs, the printed customer line is the toString method of our configured bean.

### Running the tests

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.247 s
[INFO] Finished at: 2020-01-19T16:20:14+01:00
[INFO] ------------------------------------------------------------------------
```