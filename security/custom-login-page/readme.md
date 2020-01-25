# Spring Security Custom pages

In this project, we will create ou custom login and access denied pages.

## Overview

The list of users and roles is as below :

|  User | Password | Roles   |
|---|---|---|
| user | user | USER  |
| admin | admin | ADMIN  |

Our pages structure is as below :

```log
views
└─── admin
|    └─── index.jsp     only admins
|
└─── customer
|    └─── index.jsp     only customers
|
└─── shared
|    └─── index.jsp     public
|
└─── accessDenied.jsp   public
└─── homePage.jsp       public
└─── loginPage.jsp      public
```

You can find the security rules in the `CustomSecurityConfig.java` file (admins pages only can get access by admins and customers can only be consumed by customers).

To configure the login page and the access denied page check the `MvcConfig.java` file.

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
$ docker logs custom-login-page
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the app, you can get access from this link :

- http://localhost:8080/custom-login-page/

![loginpng](https://user-images.githubusercontent.com/16627692/73105809-3464f880-3efa-11ea-9a7a-7e3ac003ae09.png)

Use one of the users form the list above.

* Admin welcome page

![hello-admin](https://user-images.githubusercontent.com/16627692/73105808-33cc6200-3efa-11ea-9a30-25cc8669fbb4.png)

* Admin tries to access to a customer page 

![404](https://user-images.githubusercontent.com/16627692/73105807-33cc6200-3efa-11ea-813d-a09b96e13b58.png)

* Shared page

![shared](https://user-images.githubusercontent.com/16627692/73105810-3464f880-3efa-11ea-9621-3f8a4ea6aa3f.png)

### Running the tests

No unit tests provided with this example.
