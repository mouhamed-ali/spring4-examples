package org.spring.tutorial.examples.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.tutorial.examples.core.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner { //this interface is used to run a specific piece of code after application start

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MailConfig mailConfig;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info("#####");
        LOGGER.info("{}", mailConfig);
        mailConfig.getDefaultRecipients().forEach(s -> LOGGER.info("{}", s));
        mailConfig.getAdditionalHeaders().forEach((key, value) -> LOGGER.info("key : {} , value : {}", key, value));
        LOGGER.info("{}", mailConfig.getCredentials());
        mailConfig.getMyList().forEach(s -> LOGGER.info("{}", s));
        LOGGER.info("#####");
    }
}
