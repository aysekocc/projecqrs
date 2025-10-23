package com.aysekoc.projecqrs.application.book.service;

import com.aysekoc.projecqrs.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book findById(UUID id);

    List<Book> findAll();

    Book save(Book book);

    UUID delete(UUID id);
}
