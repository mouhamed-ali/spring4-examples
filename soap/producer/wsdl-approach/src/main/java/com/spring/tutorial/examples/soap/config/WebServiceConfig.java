package com.spring.tutorial.examples.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /*
    Spring WS uses a different servlet type for handling SOAP messages: MessageDispatcherServlet.
    It is important to inject and set ApplicationContext to MessageDispatcherServlet.
    Without that, Spring WS will not detect Spring beans automatically.
    By naming this bean messageDispatcherServlet, it does not replace Spring Boot’s default DispatcherServlet bean.
     */

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    /*
        DefaultMethodEndpointAdapter configures annotation driven Spring WS programming model.
        This makes it possible to use the various annotations like @Endpoint mentioned earlier.

        DefaultWsdl11Definition exposes a standard WSDL 1.1 using XsdSchema

        It’s important to notice that you need to specify bean names for MessageDispatcherServlet and DefaultWsdl11Definition.
        Bean names determine the URL under which web service and the generated WSDL file is available.
        In this case, the WSDL will be available under http://<host>:<port>/ws/countries.wsdl.

        This configuration also uses the WSDL location servlet transformation servlet.setTransformWsdlLocations(true).
        If you visit http://localhost:8080/ws/countries.wsdl, the soap:address will have the proper address.
        If you instead visit the WSDL from the public facing IP address assigned to your machine, you will see that address instead.
     */
}
