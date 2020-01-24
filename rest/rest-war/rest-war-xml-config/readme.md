# Rest Spring XML example

In this project, we will develop a simple crud web app using spring rest.

## Project structure

This is a simple example of how you can create a crud application using spring rest but our configuration will be done using xml files and not annotations this time.

To deploy the app you can use the generated war (you can find it in the target directory) to install it on your server.

Otherwise, the simplest way is to use the given docker image to deploy it (i'm using tomcat 7 to deploy the app).

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
$ docker logs -f rest-app-xml
```

To shutdown the app, click on ctrl+c or use this command :

```shell script
$ docker-compose down
```

After running the application, you can test the rest endpoints using this command :

```shell script
$ curl http://localhost:8080/rest-war-xml-config/users/4
```

```json
{"id":4,"name":"jean","email":"jean@jean.com"}
```

### Running the tests

There is no junit tests provided with this project but you have a postman collection in the resources directory. Use it if you want.

![spring-rest-war-xml](https://user-images.githubusercontent.com/16627692/73061930-8460a280-3e9b-11ea-8b82-3a6a46c3a0b5.png)
