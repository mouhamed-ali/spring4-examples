# Java configuration vs XML configuration

In this article, we will show you how to use spring profiles in your application and how to configure tests to cover all the profiles.

## Overview

We will create three profiles in our application for :

- development platform
- qualification platform
- production platform

Based on the profile, we will load a properties file which contains the database connection parameters. We gonna use an H2 database and we will run an init script based on the selected profile.

You gonna find comments in the source code to explain more.

### Running the application

Go to AppMain.java class and run it (using the main method). The application will ask you to choose a profile. To select the default profile, you can simply press enter.

example :
```log
Enter a profile : 
 1) development 
 2) qualification 
 3) production 
 otherwise we gonna select the default profile
3
The profile is: 3

// app logs

db.password : prodPassword
db.user : prod-user-name
db.name : prod-database
db.host : production@ipAdress
User [id=1, name=prod1, email=prod1@gmail.com]

Jan 17, 2020 10:34:38 PM org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
INFO: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@5910e440: startup date [Fri Jan 17 22:34:37 CET 2020]; root of context hierarchy
Jan 17, 2020 10:34:38 PM org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory shutdownDatabase
INFO: Shutting down embedded database: url='jdbc:h2:mem:prod-database;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false'

Process finished with exit code 0
```

### Running the tests

Or you can simply run the unit tests using this command (in the example directory):

```shell script
$ mvn test
```

```log
Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.953 s
[INFO] Finished at: 2020-01-17T22:40:28+01:00
[INFO] ------------------------------------------------------------------------

```

Intellij report :
![core-profiles-test](https://user-images.githubusercontent.com/16627692/72648182-b3968180-397a-11ea-9aae-8acc2dde0f50.png)
