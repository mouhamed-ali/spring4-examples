# Junit xml config

In this article, we will provide a simple example of how you can configure your app using the xml configuration.


## Overview

This is example of using an xml file to declare your beans. Check ths resources directory to find the application-context.xml file.

### Running the app

You can run the Main.java class (simple main method). In this class we used the ApplicationContext class to get the loaded spring context then we can retrieve our beans by theirs names.

```log
Jan 19, 2020 4:30:25 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@6433a2: startup date [Sun Jan 19 16:30:25 CET 2020]; root of context hierarchy
Jan 19, 2020 4:30:25 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [application-context.xml]
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
[INFO] Total time:  1.556 s
[INFO] Finished at: 2020-01-19T16:46:41+01:00
[INFO] ------------------------------------------------------------------------
salto@salto-Vostro-7590:~/tutorials/java/spring4-examples/junit/junit-xml-config$ 
```