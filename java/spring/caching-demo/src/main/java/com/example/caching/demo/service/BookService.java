package com.example.caching.demo.service;

import com.example.caching.demo.domain.model.book.Book;
import com.example.caching.demo.domain.model.book.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book findBook(String isbn) {
        return bookRepository.getByIsbn(isbn);
    }

    public void cacheClear(String isbn) {
        bookRepository.evict(isbn);
    }

}