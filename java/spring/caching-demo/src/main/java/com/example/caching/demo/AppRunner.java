package com.example.caching.demo;

import com.example.caching.demo.domain.model.book.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {


  private final BookRepository bookRepository;

  public AppRunner(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    String isbn1234 = "isbn1234";
    String isbn4567 = "isbn4567";


    log.info(".... Fetching books");
    log.info(isbn1234 + " -->" + bookRepository.getByIsbn(isbn1234));
    log.info(isbn4567 + " -->" + bookRepository.getByIsbn(isbn4567));
    log.info(isbn1234 + " -->" + bookRepository.getByIsbn(isbn1234));
    log.info(isbn4567 + " -->" + bookRepository.getByIsbn(isbn4567));
    log.info(isbn1234 + " -->" + bookRepository.getByIsbn(isbn1234));
    log.info(isbn1234 + " -->" + bookRepository.getByIsbn(isbn1234));
  }

}