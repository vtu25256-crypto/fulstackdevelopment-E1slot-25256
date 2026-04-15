package com.example.bookmgmt.service;

import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book sampleBook;

    @BeforeEach
    void setUp() {
        sampleBook = Book.builder()
                .title("The Alchemist")
                .author("Paulo Coelho")
                .isbn("1234567890")
                .price(29.99)
                .build();
    }

    @Test
    void saveBook_Success() {
        when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.empty());
        when(bookRepository.save(any(Book.class))).thenReturn(sampleBook);

        Book savedBook = bookService.saveBook(sampleBook);

        assertNotNull(savedBook);
        assertEquals(sampleBook.getIsbn(), savedBook.getIsbn());
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void saveBook_DuplicateIsbn_ThrowsException() {
        when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.of(sampleBook));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            bookService.saveBook(sampleBook);
        });

        assertEquals("Book with ISBN 1234567890 already exists.", exception.getMessage());
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void saveBook_NegativePrice_ThrowsException() {
        sampleBook.setPrice(-10.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.saveBook(sampleBook);
        });

        assertEquals("Price cannot be negative.", exception.getMessage());
        verify(bookRepository, never()).save(any(Book.class));
    }
}
