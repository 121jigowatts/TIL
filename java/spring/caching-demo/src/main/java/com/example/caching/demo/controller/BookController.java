package com.example.caching.demo.controller;

import com.example.caching.demo.domain.model.book.Book;
import com.example.caching.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book/{isbn}")
    public ResponseEntity<Book> findBook(@PathVariable final String isbn) {
        log.info("isbn:{}", isbn);
        log.info("Fetching books....");
        Book book = bookService.findBook(isbn);
        log.info("Data loading is complete.");

        return ResponseEntity.ok(book);
    }

    @GetMapping(value = "/book/cache-clear/{isbn}")
    public ResponseEntity<String> cacheClear(@PathVariable final String isbn) {
        bookService.cacheClear(isbn);
        return ResponseEntity.ok("Cache clear.");
    }
}