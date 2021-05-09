package com.spring.tutorial.examples.soap.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CountryEndpointTest {

    //private final String URI = "http://localhost:8080/ws/countries.wsdl";
    // TODO change the spring boot version in the pom xml parent from 1.5.6.RELEASE to 2.2.X so we can use web-flux
    // TODO or change the version locally in this project only, otherwise keep it like this and find a way to run a mock server using the current version of spring boot

    static String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
            "                  xmlns:gs=\"http://spring.io/guides/gs-producing-web-service\">\n" +
            "    <soapenv:Header/>\n" +
            "    <soapenv:Body>\n" +
            "        <gs:getCountryRequest>\n" +
            "            <gs:name>Spain</gs:name>\n" +
            "        </gs:getCountryRequest>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";
    @Autowired
    private WebTestClient webClient;

    @Test
    public void test() throws Exception {
        this.webClient.get().uri("/ws/countries.wsdl")
                .accept(MediaType.TEXT_XML)
                .exchange().expectStatus().isOk();
        // https://stackoverflow.com/questions/59935834/spring-how-to-build-a-junit-test-for-a-soap-service/66423297#66423297
    }
}
