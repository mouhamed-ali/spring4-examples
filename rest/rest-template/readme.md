# Spring rest template

In this project, we will provide simple examples of how to use the spring rest template.

## Project structure

Spring rest template is used to make http calls to an existing server and retrieve response. 
Most of the time the response is in a json format.

In This is a simple example we gonna provide examples of how :

- configure you project to use rest template
- to make GET, POST, DELETE and PUT requests
- use a logger to log the server response
- use a mock server to make junit tests
- use a test profile

To go deep in the mock server topic, have a look at this article :

- https://www.baeldung.com/spring-mock-rest-template

### Running the application

Before running the app you have to run the server to make http calls to. You can find it here :

- https://github.com/amdouni-mohamed-ali/spring4-examples/tree/master/rest/rest-war/rest-war-example-2

After running check its endpoint in the `UserRestApiConsumer.java` file. It must be :

- http://localhost:8080/rest-war-example-2/users/

but you can change if you want but make sure to changes in the server too.

Now you can run the main method from `AppInitializer.java`. This is an example of how you can make http calls. After running it, i had this output :

```log
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -javaagent:/snap/intellij-idea-community/202/lib/idea_rt.jar=43621:/snap/intellij-idea-community/202/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/charsets.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/icedtea-sound.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/java-atk-wrapper.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/jce.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/jsse.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/resources.jar:/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/rt.jar:/home/salto/tutorials/java/spring4-examples/rest/rest-template/target/classes:/home/salto/.m2/repository/org/springframework/spring-core/4.3.10.RELEASE/spring-core-4.3.10.RELEASE.jar:/home/salto/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/home/salto/.m2/repository/org/springframework/spring-context/4.3.10.RELEASE/spring-context-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-aop/4.3.10.RELEASE/spring-aop-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-beans/4.3.10.RELEASE/spring-beans-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-expression/4.3.10.RELEASE/spring-expression-4.3.10.RELEASE.jar:/home/salto/.m2/repository/org/springframework/spring-web/4.3.10.RELEASE/spring-web-4.3.10.RELEASE.jar:/home/salto/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.9/jackson-databind-2.8.9.jar:/home/salto/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/home/salto/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.9/jackson-core-2.8.9.jar org.spring.tutorial.examples.rest.template.AppInitializer
Jan 24, 2020 4:10:35 PM org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@31221be2: startup date [Fri Jan 24 16:10:35 CET 2020]; root of context hierarchy
------------------------------------------------------ getUserById  --------------------------------------------------------------


------------------------------------------------------ getAllUsers  --------------------------------------------------------------
User [id=1, name=Dummy, email=dummy@dummy.com]
User [id=2, name=Raul, email=Raul@Raul.com]
User [id=3, name=Leo, email=Leo@Leo.com]
User [id=4, name=jean, email=jean@jean.com]
User [id=5, name=francois, email=francois@francois.com]


------------------------------------------------------ createUser  --------------------------------------------------------------
User [id=99, name=mike, email=mike@mike.com] successfully created


------------------------------------------------------ createUserSecond  --------------------------------------------------------------


------------------------------------------------------ findAllUsers  --------------------------------------------------------------
User [id=1, name=Dummy, email=dummy@dummy.com]
User [id=2, name=Raul, email=Raul@Raul.com]
User [id=3, name=Leo, email=Leo@Leo.com]
User [id=4, name=jean, email=jean@jean.com]
User [id=5, name=francois, email=francois@francois.com]
User [id=99, name=mike, email=mike@mike.com]
User [id=88, name=maxime, email=maxime@maxime.com]


------------------------------------------------------ updateUser  --------------------------------------------------------------
User [id=99, name=jeanne, email=jeanne@jeanne.com] successfully updated


------------------------------------------------------ updateUserSecond  --------------------------------------------------------------


------------------------------------------------------ getItInAnEasyWay  --------------------------------------------------------------
User [id=1, name=Dummy, email=dummy@dummy.com]
User [id=2, name=Raul, email=Raul@Raul.com]
User [id=3, name=Leo, email=Leo@Leo.com]
User [id=4, name=jean, email=jean@jean.com]
User [id=5, name=francois, email=francois@francois.com]
User [id=99, name=jeanne, email=jeanne@jeanne.com]
User [id=88, name=KingKong, email=KingKong@gmail.com]


------------------------------------------------------ deleteUser  --------------------------------------------------------------
Error Code : 200


------------------------------------------------------ deleteUserSecond  --------------------------------------------------------------


------------------------------------------------------ findAllUsers  --------------------------------------------------------------
User [id=1, name=Dummy, email=dummy@dummy.com]
User [id=2, name=Raul, email=Raul@Raul.com]
User [id=3, name=Leo, email=Leo@Leo.com]
User [id=4, name=jean, email=jean@jean.com]
User [id=5, name=francois, email=francois@francois.com]
Jan 24, 2020 4:10:35 PM org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
INFO: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@31221be2: startup date [Fri Jan 24 16:10:35 CET 2020]; root of context hierarchy

Process finished with exit code 0
```

If the request interceptor bothers you, you can disable it from `RootConfig.java` file by commenting this line :

```java
if(!Arrays.asList(env.getActiveProfiles()).contains("test")){

            //restTemplate.getInterceptors().add(new LoggingRequestInterceptor());
}
```

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
[INFO] Total time:  2.536 s
[INFO] Finished at: 2020-01-24T16:18:21+01:00
[INFO] ------------------------------------------------------------------------

```