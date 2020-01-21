# MVC Spring first example

In this project, we will develop a simple crud web app using spring mvc.

## Project structure

This is a simple example of how you can create a crud application using :

- spring mvc to serve web pages
- spring data jpa to manage the persistence of your app
- spring test to make mvc tests

If you want a more 'easy' example, you can follow this article :

- https://www.boraji.com/spring-4-mvc-hello-world-example

If there is something not so clear, you can have a look at the documentation at any time (but i've already explain many things in comments. check the code) :

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc

To deploy the app you can use the generated war (you can find it in the target directory) to install it on your server.

Otherwise, the simplest way is to use the given docker image to deploy it (i'm using tomcat 7 to deploy the app) :


```
mvc
└─── mvn-boot
└─── mvc-spring
|    └─── mvc-spring-1
|    └─── mvc-spring-2
|
```

The mvn-boot is an example of how the setup a web application using spring boot (with an embedded tomcat).
The mvc-spring are examples of how to setup a web application but the packaging will be a war this time.