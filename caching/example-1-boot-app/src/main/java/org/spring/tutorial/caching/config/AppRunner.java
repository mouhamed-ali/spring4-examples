package org.spring.tutorial.caching.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.tutorial.caching.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

    private final BookService bookService;

    public AppRunner(BookService bookService) {
        this.bookService = bookService;
    }

    /*
        this method will be executed after the application starting
     */
    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("check timing difference between methods calls in the section below");
        LOGGER.info("##########################################################################################");
        LOGGER.info("isbn-1234 -->" + bookService.getBookByIsbn("isbn-1234"));
        LOGGER.info("isbn-1234 -->" + bookService.getBookByIsbn("isbn-1234"));
        LOGGER.info("isbn-1234 -->" + bookService.getBookByIsbn("isbn-1234"));
        LOGGER.info("##########################################################################################");
    }
}
