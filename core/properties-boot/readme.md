# Spring Boot properties

In this article, we will show you how to map properties in spring boot.

## Overview

We will map this properties file :

```properties
#Simple properties
mail.host=mailer@mail.com
mail.port=9000
mail.from=sender@mail.com

#List properties
mail.defaultRecipients[0]=admin@mail.com
mail.defaultRecipients[1]=owner@mail.com

#Map Properties
mail.additionalHeaders.redelivery=true
mail.additionalHeaders.secure=true

#Object properties
mail.credentials.username=john
mail.credentials.password=password
mail.credentials.authMethod=SHA1

#Another List
my.list.of.strings=ABC,CDE,EFG
```

into java objects [String, List, Map and Object]

### Running the application

This is a spring boot application, you can run it from its main method.

output:
```log
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.3.RELEASE)

2020-01-17 23:24:24.660  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : Starting Application on salto-Vostro-7590 with PID 32172 (/home/salto/tutorials/java/spring4-examples/core/properties-boot/target/classes started by salto in /home/salto/tutorials/java/spring4-examples)
2020-01-17 23:24:24.663  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : No active profile set, falling back to default profiles: default
2020-01-17 23:24:24.706  INFO 32172 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5123a213: startup date [Fri Jan 17 23:24:24 CET 2020]; root of context hierarchy
2020-01-17 23:24:25.320  INFO 32172 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2020-01-17 23:24:25.326  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : #####
2020-01-17 23:24:25.327  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : MailConfig{host='mailer@mail.com', port=9000, fromSender='sender@mail.com'}
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : admin@mail.com
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : owner@mail.com
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : key : redelivery , value : true
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : key : secure , value : true
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : Credentials{username='john', password='password', authMethod='SHA1'}
2020-01-17 23:24:25.328  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : ABC
2020-01-17 23:24:25.329  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : CDE
2020-01-17 23:24:25.329  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : EFG
2020-01-17 23:24:25.329  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : #####
2020-01-17 23:24:25.331  INFO 32172 --- [           main] o.s.tutorial.examples.core.Application   : Started Application in 0.849 seconds (JVM running for 1.239)
2020-01-17 23:24:25.331  INFO 32172 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@5123a213: startup date [Fri Jan 17 23:24:24 CET 2020]; root of context hierarchy
2020-01-17 23:24:25.332  INFO 32172 --- [       Thread-1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown

Process finished with exit code 0

```

