# Basic authentication using JDBC - Second example

In this project, we will secure a simple mvc crud application using spring.

## Overview

In this example we gonna secure the crud web application using spring security.

We will secure the app with a basic authentication. Our users are stored in an H2 database and passwords are hashed this time (SHA-256 algorithm).
Please note that this is not a production solution because this method is not secure. Check the docs :

- https://github.com/spring-projects/spring-security/blob/master/crypto/src/main/java/org/springframework/security/crypto/password/StandardPasswordEncoder.java

The list of users and roles is as below :

|  User | Password | Roles   |
|---|---|---|
| user | user | USER  |
| admin  | admin | ADMIN  |


Our security rules are described in `SecurityConfig.java` file. As we have two roles, we gonna let the USER role retrieve data (list of users)
only and we gonna give all others permissions to the ADMIN role. This table will explain more :

| ROLE  |  Get users | create user  | update user data | delete user  |
|---|---|---|---|---|
| USER  | Yes  | Yes  | No  | No  |
| ADMIN  | Yes  | Yes  |  Yes | Yes  |

In this example we have secured the service layer and not endpoints. A user can't call a method unless he hes the right permission.
This is an example of how to let only an admin to update a user :

```java
@Secured("ROLE_ADMIN")
public Customer updateCustomer(Customer customer) {
     
    return userDao.save(customer);
}
```

### Running the application

Before running the app you have to generate the war file using this command :

```shell script
$ mvn clean package
```

You can delete the file named `logging.properties` from the resources. it is used to change the level log of our server to INFO.

To run the app, run this docker command (from the current directory):

```shell script
$ docker-compose up --build
```

To get logs, you can use this :

```shell script
$ docker logs jdbc-authentication-2
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the app, you can get access from this link :

- http://localhost:8080/jdbc-authentication-2/

![login](https://user-images.githubusercontent.com/16627692/73126688-11981a00-3fb6-11ea-9caa-04444b8f98d9.png)

Use one of the users form the list above.

* User welcome page 

![welcome](https://user-images.githubusercontent.com/16627692/73126690-1230b080-3fb6-11ea-9234-b46c6e6b862a.png)

* Show users

![show](https://user-images.githubusercontent.com/16627692/73126689-11981a00-3fb6-11ea-8a78-2a83d0f3f1b3.png)

* Try to delete the first user and you will have this error

![delete](https://user-images.githubusercontent.com/16627692/73126687-11981a00-3fb6-11ea-8f1f-6b3bf0f1641b.png)


### Running the tests

Just execute this command to run unit tests :

```shell script
$ mvn test
```

```log
Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.138 s
[INFO] Finished at: 2020-01-25T21:41:26+01:00
[INFO] ------------------------------------------------------------------------
```

To know more about testing secured services, have a look at this article :

- https://docs.spring.io/spring-security/site/docs/current/reference/html/test.html