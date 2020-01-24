# Spring Security Basic authentication

In this project, we will provide simple examples of how to use http basic authentication in a spring application.

## Overview

This is a simple mvc web application that serves jsp pages. We gonna add a security layer to authorize access to some users.
Users of this app are hard coded in the `SecurityConfigBasic.java` file. You gonna find also our security rules in the same file.

The list of users and roles is as below :

|  User | Password | Roles   |
|---|---|---|
| user | password | USER  |
| admin | password | ADMIN  |
| super-admin |  password  | ADMIN and SUPER_ADMIN  |


### Running the application

Before running the app you have to generate the war file using this command :

```shell script
$ mvn clean package
```

To run the app, run this docker command (from the current directory):

```shell script
$ docker-compose up --build
```

To get logs, you can use this :

```shell script
$ docker logs http-basic
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the app, you can get access from this link :

- http://localhost:8080/http-basic/

![login](https://user-images.githubusercontent.com/16627692/73098126-0925dd80-3ee9-11ea-9064-21f3caaff7b7.png)

Use one of the users form the list above. Notice that the page content changes depends on the user role.

* User content 

![user](https://user-images.githubusercontent.com/16627692/73098128-09be7400-3ee9-11ea-8d0e-700c349ba5ee.png)

* Admin content 

![admin](https://user-images.githubusercontent.com/16627692/73098125-088d4700-3ee9-11ea-9bc9-b12fee4e06cc.png)

* Super admin content 

![super-admin](https://user-images.githubusercontent.com/16627692/73098127-09be7400-3ee9-11ea-82aa-24bd33e0247a.png)

### Running the tests

No unit tests provided with this example.
