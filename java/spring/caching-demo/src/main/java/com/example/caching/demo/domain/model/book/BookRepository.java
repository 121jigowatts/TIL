package com.example.caching.demo.domain.model.book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}