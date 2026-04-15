package com.example.bookmgmt.service;

import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        // Business Logic: Check if ISBN already exists
        Optional<Book> existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook.isPresent()) {
            throw new RuntimeException("Book with ISBN " + book.getIsbn() + " already exists.");
        }
        
        // Business Logic: Validate price
        if (book.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
