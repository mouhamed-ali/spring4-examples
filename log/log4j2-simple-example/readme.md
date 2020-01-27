# Log4j2 simple example

This is a simple example of how to integrate log4j2 with spring boot.

## Overview

Have a look at the `pom.xml` to know more about the log4j2 integration. You have to exclude the logging library from the spring boot starter.
Then you must add the log4j2 starter project.

Check the `log4j2.xml` in the resources directory and you will find out that :

- we configured the root level log of our app to info
- the log level of our classes (package `org.spring.tutorial.examples.log4j2`) is debug
- we declared a console appender

### Running the application

It's a spring boot app, you have to run the main method in the `Application.java` class. Or you can use the spring boot maven plugin :

```shell script
$ mvn spring-boot:run
```

```log
2020-01-27 10:58:10.836 DEBUG salto-Vostro-7590 --- [           main] o.s.t.e.l.Application                    : Debugging log
2020-01-27 10:58:10.837  INFO salto-Vostro-7590 --- [           main] o.s.t.e.l.Application                    : Info log
2020-01-27 10:58:10.837  WARN salto-Vostro-7590 --- [           main] o.s.t.e.l.Application                    : Hey, This is a warning!
2020-01-27 10:58:10.837 ERROR salto-Vostro-7590 --- [           main] o.s.t.e.l.Application                    : Oops! We have an Error. OK
2020-01-27 10:58:10.837 FATAL salto-Vostro-7590 --- [           main] o.s.t.e.l.Application                    : Damn! Fatal error. Please fix me.
```

As you can see the Trace line is not showing up because our log level is Debug.

### Running the tests

There is no unit tests provided with this example.