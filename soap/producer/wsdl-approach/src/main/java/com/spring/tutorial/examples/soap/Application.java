package com.spring.tutorial.examples.soap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
    check this spring tutorial : https://spring.io/guides/gs/producing-web-service/
 */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
        execute mvn clean install under root/soap/producer/wsdl-approach to generate xsd classes
        To test tha app :
            - use a test tool like soapui
            - go to the resources test folder and execute this command line (using shell) :
                $ curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws (you can execute this command using git bash on windows)
     */
}
