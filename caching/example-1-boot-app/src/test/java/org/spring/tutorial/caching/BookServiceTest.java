package org.spring.tutorial.caching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.caching.entities.Book;
import org.spring.tutorial.caching.repository.BookRepository;
import org.spring.tutorial.caching.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
/*
    Spring Runner is used to launch up a spring context in unit tests.
 */
@SpringBootTest
/*
    This annotation indicates that the context under test is a @SpringBootApplication.
 */
public class BookServiceTest {

    public static final String ISBN = "ISBN-1421";
    public static final String TITLE = "Mockito by examples";
    @MockBean
    /*
     *    @MockBean annotation creates a mock for BookRepository. This mock is used in the Spring Context instead of the real BookRepository.
     */
    BookRepository bookRepository;

    @Autowired
    /*
     * Pick the Business Service from the Spring Context and autowire it in.
     * this bookRepository mock will be injected in this bean
     */
    BookService bookService;

    @Test
    public void getBookIsbnTest() {
        //we gonna test the caching behavior of a Spring Data Repository method annotated with @Cacheable
        when(bookRepository.getByIsbn(anyString())).thenReturn(new Book().setIsbn(ISBN).setTitle(TITLE));

        //first call
        Book book = bookService.getBookByIsbn(ISBN);
        assertThat(book.getIsbn()).isEqualTo(ISBN);
        assertThat(book.getTitle()).isEqualTo(TITLE);

        //second call (using cache this time)
        book = bookService.getBookByIsbn(ISBN);
        assertThat(book.getIsbn()).isEqualTo(ISBN);
        assertThat(book.getTitle()).isEqualTo(TITLE);

        // Verify that the getByIsbn method from the mock repository was invoked once ==> spring cache works fine :)
        verify(bookRepository, times(1)).getByIsbn(ISBN);
    }

}
