# Spring boot caching

In this article, we will show you how to enable caching in spring and improve the performance of your application.

you can find this example on spring tutorials :

- https://spring.io/guides/gs/caching/

## Overview

Each time you some static parameters that never changes or takes a while to change like the ip address of a server, it's better to make it in the cache to improve performances.

In this example, we will create a repo class that render a book based on its isbn. Well, this time takes 3 seconds at lease to render the book.

```java
@Component
public class BookRepositoryImpl implements BookRepository {

    public Book getByIsbn(String isbn) {
        //in a real project, this method will retrieve data from a database
        simulateSlowService();
        return new Book().setIsbn(isbn).setTitle("Some book");
    }

    // Don't do this at home
    protected void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
```

So we will cache the method that makes the call (from the service layer). And so the next time we will make a call to this method with the same isbn, spring will render that cached book and will not make the repo call. 

### Running the application

This is a spring boot app, you can run it from its main method.

```log
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -javaagent:/snap/intellij-idea-community/197/lib/idea_rt.jar=41357:/snap/intellij-idea-community/197/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/charsets.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/icedtea-sound.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/java-atk-wrapper.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/jce.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/jsse.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/resources.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/rt.jar:/home/salto/tutorials/java/spring4-examples/caching/example-1-boot-app/target/classes:/home/salto/.m2/repository/org/springframework/spring-aop/4.3.10.RELEASE/spring-aop-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-beans/4.3.5.RELEASE/spring-beans-4.3.5.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-core/4.3.10.RELEASE/spring-core-4.3.10.RELEASE.jar:/home/salto/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/home/salto/.m2/repository/org/springframework/boot/spring-boot-starter/1.4.3.RELEASE/spring-boot-starter-1.4.3.RELEASE.jar:/home/salto/.m2/repository/org/springframework/boot/spring-boot/1.4.3.RELEASE/spring-boot-1.4.3.RELEASE.jar:/home/salto/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.4.3.RELEASE/spring-boot-autoconfigure-1.4.3.RELEASE.jar:/home/salto/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.4.3.RELEASE/spring-boot-starter-logging-1.4.3.RELEASE.jar:/home/salto/.m2/repository/ch/qos/logback/logback-classic/1.1.8/logback-classic-1.1.8.jar:/home/salto/.m2/repository/ch/qos/logback/logback-core/1.1.8/logback-core-1.1.8.jar:/home/salto/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.22/jcl-over-slf4j-1.7.22.jar:/home/salto/.m2/repository/org/slf4j/jul-to-slf4j/1.7.22/jul-to-slf4j-1.7.22.jar:/home/salto/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.22/log4j-over-slf4j-1.7.22.jar:/home/salto/.m2/repository/org/yaml/snakeyaml/1.17/snakeyaml-1.17.jar:/home/salto/.m2/repository/org/springframework/boot/spring-boot-starter-cache/1.4.3.RELEASE/spring-boot-starter-cache-1.4.3.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-context/4.3.10.RELEASE/spring-context-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-expression/4.3.5.RELEASE/spring-expression-4.3.5.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-context-support/4.3.5.RELEASE/spring-context-support-4.3.5.RELEASE.jar:/home/salto/.m2/repository/org/slf4j/slf4j-api/1.7.22/slf4j-api-1.7.22.jar org.spring.tutorial.caching.SpringCacheTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.3.RELEASE)

2020-01-18 11:48:29.831  INFO 11095 --- [           main] o.s.tutorial.caching.SpringCacheTest     : Starting SpringCacheTest on salto-Vostro-7590 with PID 11095 (/home/salto/tutorials/java/spring4-examples/caching/example-1-boot-app/target/classes started by salto in /home/salto/tutorials/java/spring4-examples)
2020-01-18 11:48:29.833  INFO 11095 --- [           main] o.s.tutorial.caching.SpringCacheTest     : No active profile set, falling back to default profiles: default
2020-01-18 11:48:30.842  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : check timing difference between methods calls in the section below
2020-01-18 11:48:30.842  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : ##########################################################################################
2020-01-18 11:48:33.846  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : isbn-1234 -->Book{isbn='isbn-1234', title='Some book'}
2020-01-18 11:48:33.847  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : isbn-1234 -->Book{isbn='isbn-1234', title='Some book'}
2020-01-18 11:48:33.847  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : isbn-1234 -->Book{isbn='isbn-1234', title='Some book'}
2020-01-18 11:48:33.847  INFO 11095 --- [           main] o.s.tutorial.caching.config.AppRunner    : ##########################################################################################
```

You can see from logs that the first call took 3 seconds.

### Running the tests

We used a mock in the test to count the number of calls to the repo method and test the cache.

You can simply run the unit tests using this command (in the current directory):

```shell script
$ mvn test
```

```log
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.054 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.798 s
[INFO] Finished at: 2020-01-18T12:05:59+01:00
[INFO] ------------------------------------------------------------------------

```