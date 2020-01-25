# Spring Security Custom filter

In this project, we will create ou custom filter.

## Overview

In this example we will create a filter to intercept all the requests and add a custom message to each one depends on a user role.

The list of users (in memory users) and roles is as below :

|  User | Password | Roles   |
|---|---|---|
| user | user | USER  |
| admin | admin | ADMIN  |

If the user has an ADMIN role we will add this message :

- hey admin, you are a little weirdo. you have to work harder.

And if he has a USER role the message will be :

- hey user, you are awesome. you are our fortune.

And in all cases we will add :

- this request has passed by our custom filter !!!

This filter will be added after the `UsernamePasswordAuthenticationFilter` filter so we can have access to the user role.

You can find the filter in the `filters` package.

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
$ docker logs custom-filter-chain
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the app, you can get access from this link :

- http://localhost:8080/custom-filter-chain/

![login](https://user-images.githubusercontent.com/16627692/73127463-e23ada80-3fc0-11ea-9d88-75a9d679444b.png)

* Admin page

![admin](https://user-images.githubusercontent.com/16627692/73127462-e1a24400-3fc0-11ea-9086-e551705a2d37.png)

* User page

![user](https://user-images.githubusercontent.com/16627692/73127464-e23ada80-3fc0-11ea-95ed-3c67804ea818.png)

### Running the tests

No unit tests provided with this example.
