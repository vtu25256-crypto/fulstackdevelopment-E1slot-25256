package com.example.bookmgmt.repository;

import com.example.bookmgmt.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByIsbn_Found() {
        Book book = Book.builder()
                .title("Tale of Two Cities")
                .author("Charles Dickens")
                .isbn("111222333")
                .price(15.0)
                .build();
        bookRepository.save(book);

        Optional<Book> found = bookRepository.findByIsbn("111222333");

        assertTrue(found.isPresent());
        assertEquals("Tale of Two Cities", found.get().getTitle());
    }

    @Test
    void findByIsbn_NotFound() {
        Optional<Book> found = bookRepository.findByIsbn("999999999");
        assertFalse(found.isPresent());
    }

    @Test
    void saveBook_PersistsData() {
        Book book = Book.builder()
                .title("New Book")
                .author("Author")
                .isbn("444555")
                .price(10.0)
                .build();
        
        Book savedBook = bookRepository.save(book);
        
        assertNotNull(savedBook.getId());
        assertEquals("New Book", bookRepository.findById(savedBook.getId()).get().getTitle());
    }
}
